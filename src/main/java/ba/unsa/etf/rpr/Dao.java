package ba.unsa.etf.rpr;

import java.util.List;

public interface Dao<T> {
    T getById(int id);

    /**
     * Adds an object to database
     */
    T add(T o);

    /**
     * Updates an object in database
     */
    T update(T o);

    /**
     * Deletes an object from database
     */
    T delete(T o);

    /**
     * Returns all objects from database
     */
    List<T> getAll();
}
