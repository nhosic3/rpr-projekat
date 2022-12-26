package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Client;
import ba.unsa.etf.rpr.exceptions.ServiceException;

import java.util.List;

public interface ClientDao extends Dao<Client> {
    /**
     * Searches clients by names
     */
    List<Client> searchByName(String name) throws ServiceException;

    /**
     * Searches clients by emails
     */
    Client searchByEmail(String email) throws ServiceException;

    /**
     * Searches clients by passwords
     */
    Client searchByPassword(String password) throws ServiceException;
}
