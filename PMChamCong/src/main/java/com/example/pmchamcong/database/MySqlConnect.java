package com.example.pmchamcong.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnect {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/pmchamcong";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    public static Connection connect() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
            if (connection != null) {
                System.out.println("Kết nối thành công!");
            } else {
                System.out.println("Không thể kết nối đến cơ sở dữ liệu!");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
    public static void disconnect(Connection connection) {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Đã đóng kết nối!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
