package com.irina.database;


import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

public class DBConnector {

    private final String URL = "jdbc:mysql://localhost:3306/peopledescription";
    private final String USER = "root";
    private final String PASSWORD = "root";

    private Connection connection;

    public DBConnector(){
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public Connection GetConnection(){
        return connection;
    }
}
