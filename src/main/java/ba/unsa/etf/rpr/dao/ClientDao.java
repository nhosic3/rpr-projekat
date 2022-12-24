package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Client;

import java.util.List;

public interface ClientDao extends Dao<Client> {
    /**
     * Searches client by names
     */
    List<Client> searchByName(String name);

    /**
     * Searches client by ID
     */
    List<Client> searchById(int id);
}