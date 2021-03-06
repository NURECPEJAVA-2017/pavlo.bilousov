package ua.nure.bilousov.db;

import java.util.Collection;



public interface DAO<T> {
    T create (T t ) throws DatabaseException;
    T update (T t) throws DatabaseException;
    void delete(T t) throws DatabaseException;
    T find(Long id) throws DatabaseException;
    Collection<T> findAll() throws DatabaseException;

    
    
}
   
