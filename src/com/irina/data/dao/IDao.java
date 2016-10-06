package src.com.irina.data.dao;


import src.com.irina.data.entity.IEntity;

import java.util.List;

public interface IDao<T extends IEntity> {
    void create(T entity) throws DaoException;
    T read(String pattern) throws DaoException;
    void update(T entity) throws DaoException;
    void delete(T entity) throws DaoException;
    List<T> getAll() throws DaoException;
}
