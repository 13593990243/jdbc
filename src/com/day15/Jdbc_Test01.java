package com.day15;

import java.sql.*;

public class Jdbc_Test01 {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;

        try {
            //   加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //   获取连接
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp", "root", "123456");
//     获取sql语句
            String sql = "select * from emp";
            preparedStatement = connection.prepareStatement(sql);
            rs = preparedStatement.executeQuery();
//            遍历
            while (rs.next()) {
                int empno = rs.getInt("empno");
                String ename = rs.getString("ename");
                System.out.println(empno + ename);
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
