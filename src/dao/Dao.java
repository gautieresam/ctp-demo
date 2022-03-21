package dao;

import java.util.List;

public interface Dao<T> {
    public boolean create(T obj) ;
    public T find(Class c,int id) ;
    public List<T> findAll(Class c);
    public boolean update (T obj) ;
    public boolean delete (T obj) ;
    public boolean deleteAll() ;
    public void close();

}
