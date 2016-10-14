package com.irina.data.dao;


import com.irina.data.entity.Entity;

import java.util.List;

public class UserDAOImpl extends AbstructDAO implements UserDAO {
    @Override
    public String getEntityName() {
        return "User";
    }
}
