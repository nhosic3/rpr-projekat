package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.Client;
import ba.unsa.etf.rpr.exceptions.ServiceException;

import java.util.List;

public class ClientManager {
    public List<Client> searchByName(String n) throws ServiceException {
        return DaoFactory.clientDao().searchByName(n);
    }

    public Client searchByEmail(String e) throws ServiceException {
        return DaoFactory.clientDao().searchByEmail(e);
    }
    public Client add(Client c) throws ServiceException {
        return DaoFactory.clientDao().add(c);
    }

    public List<Client> getAll() throws ServiceException {
        return DaoFactory.clientDao().getAll();
    }

    public Client update(Client c) throws ServiceException {
        return DaoFactory.clientDao().update(c);
    }

    public void delete(int id) throws ServiceException {
        DaoFactory.clientDao().delete(id);
    }
}
