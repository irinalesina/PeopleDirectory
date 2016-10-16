package com.irina.data.dao;

import com.irina.data.entity.Entity;

import java.util.List;

public abstract class AbstructDAO implements DAO {
    private static final String DELETE = "DELETE FROM %s WHERE id = %d";
    private Session session;
    public abstract String getEntityName();


    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    @Override
    public List getAll() {
        return null;
    }

    @Override
    public boolean update(Entity entity) {
        return false;
    }

    @Override
    public Entity getEntityById(int id) {
        return null;
    }

    @Override
    public boolean delete(int id) {
        String sql = String.format(DELETE, getEntityName(), id);
        return session.update(sql);
    }

    @Override
    public boolean create(Entity entity) {
        return false;
    }
}
