package com.day15;

import java.math.BigDecimal;
import java.sql.*;

public class Jdbc_Test02 {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try {
//            加载驱动
            Class.forName("com.mysql.jdbc.Driver");
//            获取链接
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp", "root", "123456");
//            获取sql语句
            String sql = "select * from emp where ename like ?";
            preparedStatement = connection.prepareStatement(sql);
            //  执行
            preparedStatement.setString(1,"%张%");
            rs = preparedStatement.executeQuery();
//          遍历
            while (rs.next()) {
                int empno = rs.getInt("empno");
                String ename = rs.getString("ename");
                Date hiredate = rs.getDate("hiredate");
                BigDecimal sal = rs.getBigDecimal("sal");
                System.out.println("编号:" + empno + "姓名:" + ename + "入职日期:" + hiredate + "工资:" + sal);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null)
                    rs.close();
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
