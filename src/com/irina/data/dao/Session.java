package com.irina.data.dao;


import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.sql.ResultSet;

public class Session {
    private ConnectionProvider connectionProvider;

    public ResultSet first(String sql, Assembler assembler){
        throw new NotImplementedException();
    }
}
