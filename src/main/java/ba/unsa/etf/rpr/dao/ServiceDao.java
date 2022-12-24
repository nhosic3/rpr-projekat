package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Service;

import java.util.List;

public interface ServiceDao extends Dao<Service> {
    /**
     * Searches services by service type
     */
    List<Service> searchByServiceType(String serviceType);

    /**
     * Searches services by ID
     */
    List<Service> searchById(int id);
}