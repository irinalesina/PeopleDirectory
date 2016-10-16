package com.irina.data.dao;


import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Session {
    private ConnectionProvider connectionProvider;


    public ResultSet first(String sql, Assembler assembler){
        throw new NotImplementedException();
    }

    public boolean update(String sql){
        boolean result = false;
        try {
            PreparedStatement ps = connectionProvider.getConnection().prepareStatement(sql);
            result = ps.executeUpdate() != 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

}
