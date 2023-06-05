package com.solvd.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnection {
    private static String url = "jdbc:mysql://127.0.0.1:3306/mydb";
    private static String user = "root";
    private static String password = "H_7n9fpF9vW66yf";

    public static Connection getConnection() throws SQLException {
        Connection connection = null;
        connection = DriverManager.getConnection(url, user, password);

        return connection;
    }
}
