package ba.unsa.etf.rpr.dao;
import ba.unsa.etf.rpr.exceptions.ServiceException;
import java.util.List;

public interface Dao<T> {
    T getById(int id)throws ServiceException;

    /**
     * Adds an object to database
     */
    T add(T o)throws ServiceException;

    /**
     * Updates an object in database
     */
    T update(T o)throws ServiceException;

    /**
     * Deletes an object from database
     */
    void delete(int id)throws ServiceException;

    /**
     * Returns all objects from database
     */
    List<T> getAll()throws ServiceException;
}
