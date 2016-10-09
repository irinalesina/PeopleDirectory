package src.com.irina.data.dao;


import sun.jdbc.odbc.ee.ConnectionPool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public abstract class AbstractController<E, K> {
    private Connection connection;
    //private ConnectionPool connectionPool;
    private static final String DB_URL = "jdbc:mysql://localhost/people";
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "root";

    public AbstractController() {
        // good work, solve it
        //connectionPool = ConnectionPool.getConnectionPool();
        //connection = connectionPool.getConnection();

        //not to all time
        try{
            connection = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
        } catch (SQLException ex){
            ex.printStackTrace();
        }
    }

    public abstract List<E> getAll();
    public abstract E update(E entity);
    public abstract E getEntityById(K id);
    public abstract boolean delete(K id);
    public abstract boolean create(E entity);

    // Возвращения экземпляра Connection в пул соединений
    public void returnConnectionInPool() throws SQLException {
        //connectionPool.returnConnection(connection);
        if(!connection.isClosed())
            connection.close();
    }

    // Получение экземпляра PrepareStatement
    public PreparedStatement getPrepareStatement(String sql) {
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ps;
    }

    // Закрытие PrepareStatement
    public void closePrepareStatement(PreparedStatement ps) {
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}