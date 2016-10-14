package com.irina.data.dao;


import com.irina.data.entity.Entity;
import java.util.List;

public interface DAO<E extends Entity> {
    List<E> getAll();
    boolean update(E entity);
    E getEntityById(int id);
    boolean delete(int id);
    boolean create(E entity);

}
