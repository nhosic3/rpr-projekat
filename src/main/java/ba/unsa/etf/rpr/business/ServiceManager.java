package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.Client;
import ba.unsa.etf.rpr.domain.Service;
import ba.unsa.etf.rpr.exceptions.ServiceException;

import java.util.List;

public class ServiceManager {
    /**
     * A method which searches service by its id
     */
    public Service searchById(int id) throws ServiceException {
        return DaoFactory.serviceDao().searchById(id);
    }
    /**
     * A method which searches services by client id
     */
    public List<Service> searchByClientId(int c_id) throws ServiceException {
        return DaoFactory.serviceDao().searchByClientId(c_id);
    }
    /**
     * A method which adds service to database
     */
    public Service add(Service s) throws ServiceException {
        return DaoFactory.serviceDao().add(s);
    }
    /**
     * A method which creates list of all services
     */
    public List<Service> getAll() throws ServiceException {
        return DaoFactory.serviceDao().getAll();
    }
    /**
     * A method which deletes service by its id
     */
    public void delete(int id) throws ServiceException {
        DaoFactory.serviceDao().delete(id);
    }
    /**
     * A method which updates service
     */
    public Service update(Service s) throws ServiceException {
        return DaoFactory.serviceDao().update(s);
    }
}
