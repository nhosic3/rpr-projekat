package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.Client;
import ba.unsa.etf.rpr.domain.Service;
import ba.unsa.etf.rpr.exceptions.ServiceException;

import java.util.List;

public class ServiceManager {
    public List<Service> searchByServiceType(String st) throws ServiceException {
        return DaoFactory.serviceDao().searchByServiceType(st);
    }

    public List<Service> searchByClientId(int c_id) throws ServiceException {
        return DaoFactory.serviceDao().searchByClientId(c_id);
    }
    public Service add(Service s) throws ServiceException {
        return DaoFactory.serviceDao().add(s);
    }

    public List<Service> getAll() throws ServiceException {
        return DaoFactory.serviceDao().getAll();
    }

    public Service update(Service s) throws ServiceException {
        return DaoFactory.serviceDao().update(s);
    }

    public void delete(int id) throws ServiceException {
        DaoFactory.serviceDao().delete(id);
    }
}
