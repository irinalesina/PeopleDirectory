package com.irina.data.dao.toDELETE;

import com.irina.data.entity.Entity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;


public abstract class AbstractController<E extends Entity, K> {
    private Connection connection;
    private static final String DB_URL = "jdbc:mysql://localhost/people";
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "root";

    public AbstractController() {
        try{
            connection = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
        } catch (SQLException ex){
            ex.printStackTrace();
        }
    }

    public abstract List<E> getAll();
    public abstract boolean update(E entity);
    public abstract E getEntityById(K id);
    public abstract boolean delete(K id);
    public abstract boolean create(E entity);

    public void returnConnectionInPool() throws SQLException {
        if(!connection.isClosed())
            connection.close();
    }

    public PreparedStatement getPrepareStatement(String sql) {
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ps;
    }

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