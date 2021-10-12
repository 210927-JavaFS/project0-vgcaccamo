package com.revature.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String url = "jdbc:postgresql://revature-training-fall21.cfgrf25ehe0o.us-east-2.rds.amazonaws.com:5432/project0bank";
        String username = "postgres";
        String password = "password";

        return DriverManager.getConnection(url, username, password);
    }
}
