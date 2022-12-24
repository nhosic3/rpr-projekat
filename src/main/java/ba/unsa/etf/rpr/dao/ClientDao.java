package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Client;
import ba.unsa.etf.rpr.exceptions.ServiceException;

import java.util.List;

public interface ClientDao extends Dao<Client> {
    /**
     * Searches clients by names
     */
    List<Client> searchByName(String name) throws ServiceException;
}
