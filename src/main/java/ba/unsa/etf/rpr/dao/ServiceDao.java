package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Service;
import ba.unsa.etf.rpr.exceptions.ServiceException;

import java.util.Date;
import java.util.List;

public interface ServiceDao extends Dao<Service> {
    /**
     * Searches services by service type
     */
    List<Service> searchByServiceType(String serviceType) throws ServiceException;

    /**
     * Searches services by client ID
     */
    List<Service> searchByClientId(int id) throws ServiceException;

    /**
     * Searches services by start time
     */
    List<Service> searchByStartTime(Date st) throws ServiceException;

    /**
     * Searches services by end time
     */
    List<Service> searchByEndTime(Date et) throws ServiceException;
}
