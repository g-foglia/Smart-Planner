package org.gennisilv.smartplanner.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConPool {
    private static Connection connection;

    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://127.0.0.1:3306/smartplannerdb";
        String username = "root";
        String password = "1836..1836Ab";
        connection = DriverManager.getConnection(url,username,password);

        return connection;
    }
}
