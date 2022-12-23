package ba.unsa.etf.rpr;

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
