package com.irina.data.dao;

import com.irina.data.entity.Entity;

import java.util.List;

public abstract class AbstructDAO implements DAO {
    private Session session;
    public abstract String getEntityName();

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
        return false;
    }

    @Override
    public boolean create(Entity entity) {
        return false;
    }
}
