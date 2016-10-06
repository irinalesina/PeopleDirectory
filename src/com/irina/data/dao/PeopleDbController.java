package src.com.irina.data.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class PeopleDbController {
    private static final String DB_URL = "jdbc:mysql://localhost/people";
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "root";

    public PeopleDbController() {}

    public static Connection getConection() throws Exception{
        return DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
    }
}
