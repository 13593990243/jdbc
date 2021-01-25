package com.day16.job.sever;

import com.utils.JdbcUtils;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

//1 从数据库Student表中查询出所有的学生信息，然后用序列化流保存到student.txt文件中，学生表中有姓名，年龄，性别
//2 把student.txt文件通过反序列化，然后存入数据库Student2表中
public class Test07 {
    public static void main(String[] args) {
        ArrayList<Student> list = select();
        a(list);
        ArrayList<Student> b = b(list);
        add(b);
        System.out.println("nishishabi");
    }

    public static void a(ArrayList list) {
        ObjectOutputStream os = null;
        try {
            FileOutputStream fos = new FileOutputStream("D:\\file\\student.txt");
            os = new ObjectOutputStream(fos);
            for (int i = 0; i < list.size(); i++) {
                os.writeObject(list.get(i));
                os.flush();
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (os != null) {
                    os.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    public static ArrayList<Student> b(ArrayList list) {
        ArrayList<Student> list1 = new ArrayList<>();
        ObjectInputStream ois = null;
        try {
            FileInputStream fis = new FileInputStream("d:\\file\\student.txt");
            ois = new ObjectInputStream(fis);
            for (int i = 0; i < list.size(); i++) {
                Student str = (Student) ois.readObject();
                System.out.println(str);
                list1.add(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return list1;
    }

    public static ArrayList<Student> select() {
        ArrayList<Student> list = new ArrayList<>();
        Connection conn = JdbcUtils.getConn();
        PreparedStatement prep = null;
        ResultSet rs = null;
        String sql = "select * from  student";
        try {
            prep = conn.prepareStatement(sql);
            rs = prep.executeQuery();
            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setClass_id(rs.getInt("class_id"));
                student.setName(rs.getString("name"));
                student.setSex(rs.getString("sex"));
                student.setAge(rs.getInt("age"));
                list.add(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(conn, prep, rs);
        }
        return list;
    }

    public static void add(ArrayList<Student> list) {
        Connection conn = JdbcUtils.getConn();
        String sql = "insert into student2 (id,class_id,name,sex,age) values";
        for (int i = 0; i < list.size(); i++) {
            sql += "(" + list.get(i).getId() +
                    "," + list.get(i).getClass_id() +
                    "," + "'" + list.get(i).getName() + "'" +
                    "," + "'" + list.get(i).getSex() + "'" +
                    "," + list.get(i).getAge() +
                    "),";
        }
        sql = sql.substring(0,sql.length()-1);
        try {
            PreparedStatement prep = conn.prepareStatement(sql);
            int i = prep.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
