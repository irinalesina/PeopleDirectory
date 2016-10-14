package com.irina.data.dao;


public class UserAccountDAOImpl extends AbstructDAO implements UserAccountDAO {
    @Override
    public String getEntityName() {
        return "UserAccount";
    }
}
