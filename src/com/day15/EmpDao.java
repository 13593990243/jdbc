package com.day15;

import com.utils.JdbcUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmpDao {
    public static void main(String[] args) throws Exception {
        String str = "2021-1-21";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date parse = sdf.parse(str);
        java.sql.Date hiredate = new java.sql.Date(parse.getTime());
////        Emp emp = new Emp("admin", "校长", hiredate, new BigDecimal(8000.00), new BigDecimal(100.00), 100);
//        Emp emp1 = new Emp(5, "admin", "校长", hiredate, new BigDecimal(8000.00), new BigDecimal(100.00), 100);
////        add(emp);
//        update(emp1);
//        ArrayList<Emp> list = select("张");
//        list.stream().forEach(n -> {
//            System.out.println(n);
//        });
//        delete(8);
//        ArrayList<Emp> list = select(2);
//        list.stream().forEach(n -> {
//            System.out.println(n);
//        });
        ArrayList<Emp> list = new ArrayList<>();
        Emp emp = new Emp("admin1", "校长", hiredate, new BigDecimal(8000.00), new BigDecimal(100.00), 100);
        Emp emp1 = new Emp("admin2", "校长", hiredate, new BigDecimal(8000.00), new BigDecimal(100.00), 100);
        Emp emp2 = new Emp("admin3", "校长", hiredate, new BigDecimal(8000.00), new BigDecimal(100.00), 100);
        list.add(emp);
        list.add(emp1);
        list.add(emp2);
        add(list);
    }

    //添加
    public static void add(Emp emp) throws Exception {
        Connection conn = JdbcUtils.getConn();
        String sql = "insert into emp (ename,job,hiredate,sal,depino,comm) values (?,?,?,?,?,?)";
        PreparedStatement prep = conn.prepareStatement(sql);
        prep.setString(1, emp.geteName());
        prep.setString(2, emp.getJob());
        prep.setDate(3, (java.sql.Date) emp.getHiredate());
        prep.setBigDecimal(4, emp.getSal());
        prep.setInt(5, emp.getDepino());
        prep.setBigDecimal(6, emp.getComm());
        int rs = prep.executeUpdate();
        if (rs > 0) {
            System.out.println("success");
        } else {
            System.out.println("fail");
        }
        JdbcUtils.close(conn, prep);
    }

    //添加多行
    public static void add( ArrayList<Emp> list) throws Exception {
        Connection conn = JdbcUtils.getConn();
        String sql = "insert into emp (ename,job,hiredate,sal,depino,comm) values";
        for (int i = 0; i < list.size(); i++) {
            sql += "(" + "'"+list.get(i).geteName()+"'" +
                    "," + "'"+list.get(i).getJob()+"'" +
                    "," + "'"+list.get(i).getHiredate()+"'" +
                    "," + list.get(i).getSal() +
                    "," + list.get(i).getDepino() +
                    "," + list.get(i).getComm() +
                    "),";
        }
        sql= sql.substring(0,sql.length()-1);
        System.out.println(sql);
        PreparedStatement prep = conn.prepareStatement(sql);
        int rs = prep.executeUpdate();
        if (rs > 0) {
            System.out.println("success");
        } else {
            System.out.println("fail");
        }
        JdbcUtils.close(conn, prep);
    }

    //修改
    public static void update(Emp emp) throws Exception {
        Connection conn = JdbcUtils.getConn();
        String sql = "update emp set ename=?,job=?,hiredate=?,sal=?,depino=?,comm=? where empno=?";
        PreparedStatement prep = conn.prepareStatement(sql);
        prep.setString(1, emp.geteName());
        prep.setString(2, emp.getJob());
        prep.setDate(3, (java.sql.Date) emp.getHiredate());
        prep.setBigDecimal(4, emp.getSal());
        prep.setInt(5, emp.getDepino());
        prep.setBigDecimal(6, emp.getComm());
        prep.setInt(7, emp.getEmpno());
        int rs = prep.executeUpdate();
        if (rs > 0) {
            System.out.println("success");
        } else {
            System.out.println("fail");
        }
        JdbcUtils.close(conn, prep);

    }

    //删除
    public static void delete(Integer empno) throws Exception {
        Connection conn = JdbcUtils.getConn();
        String sql = "delete from emp where empno=?";
        PreparedStatement prep = conn.prepareStatement(sql);
        prep.setInt(1, empno);
        int i = prep.executeUpdate();
        if (i > 0) {
            System.out.println("success");
        } else {
            System.out.println("fail");
        }
        JdbcUtils.close(conn, prep);
    }

    //    模糊查询
    public static ArrayList<Emp> select(String ename) {
        ArrayList<Emp> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement prep = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.getConn();
            String sql = "select * from emp where ename like ?";
            prep = conn.prepareStatement(sql);
            prep.setString(1, "%" + ename + "%");
            rs = prep.executeQuery();
            while (rs.next()) {
                Emp emp = new Emp();
                emp.setEmpno(rs.getInt("empno"));
                emp.seteName(rs.getString("ename"));
                emp.setJob(rs.getString("job"));
                emp.setHiredate(rs.getDate("hiredate"));
                emp.setSal(rs.getBigDecimal("sal"));
                emp.setComm(rs.getBigDecimal("comm"));
                emp.setDepino(rs.getInt("depino"));
                list.add(emp);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(conn, prep, rs);
        }
        return list;
    }

    //分页查询
    public static ArrayList<Emp> select(Integer page) {
        ArrayList<Emp> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement prep = null;
        ResultSet rs = null;
        try {
            Page page1 = new Page();
            Integer pageSize = page1.getPageSize();
            conn = JdbcUtils.getConn();
            String sql = "select * from emp limit ?,?";
            prep = conn.prepareStatement(sql);
            prep.setInt(1, pageSize);
            prep.setInt(2, page);
            rs = prep.executeQuery();
            while (rs.next()) {
                Emp emp = new Emp();
                emp.setEmpno(rs.getInt("empno"));
                emp.seteName(rs.getString("ename"));
                emp.setJob(rs.getString("job"));
                emp.setHiredate(rs.getDate("hiredate"));
                emp.setSal(rs.getBigDecimal("sal"));
                emp.setComm(rs.getBigDecimal("comm"));
                emp.setDepino(rs.getInt("depino"));
                list.add(emp);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(conn, prep, rs);
        }
        return list;
    }
}
