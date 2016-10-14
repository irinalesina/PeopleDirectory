package com.irina.data.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {
    private static final String DB_URL = "jdbc:mysql://localhost/people";
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "root";


    public Connection getConnection() {
        Connection connection = null;
        try{
            connection = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
        } catch (SQLException ex){
            ex.printStackTrace();
        }
        return connection;
    }
}
