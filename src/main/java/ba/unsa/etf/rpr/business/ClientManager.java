package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.Client;
import ba.unsa.etf.rpr.exceptions.ServiceException;

import java.util.List;

public class ClientManager {
    /**
     * A method which searches clients by their first name
     * @return list of all client with given name
     */
    public List<Client> searchByName(String n) throws ServiceException {
        return DaoFactory.clientDao().searchByName(n);
    }
    /**
     * A method which searches client by his ID
     * @return client with given ID
     */
    public Client searchById(int id) throws ServiceException {
        return DaoFactory.clientDao().searchById(id);
    }
    /**
     * A method which searches client by his email
     * @return client with given email
     */
    public Client searchByEmail(String e) throws ServiceException {
        return DaoFactory.clientDao().searchByEmail(e);
    }
    /**
     * A method which searches clients by their first passwords (necessary for login check)
     * @return client with given password
     */
    public Client searchByPassword(String p) throws ServiceException {
        return DaoFactory.clientDao().searchByPassword(p);
    }
    /**
     * A method which adds clients to the database
     * @return client if added correctly
     */
    public Client add(Client c) throws ServiceException {
        return DaoFactory.clientDao().add(c);
    }
    /**
     * A method which creates list of all clients
     * @return list of all clients
     */
    public List<Client> getAll() throws ServiceException {
        return DaoFactory.clientDao().getAll();
    }
    /**
     * A method which deletes client from database
     * @return client if deleted correctly
     */
    public void delete(int id) throws ServiceException {
        DaoFactory.clientDao().delete(id);
    }
    /**
     * A method which updates client
     * @return client if updated correctly
     */
    public Client update(Client c) throws ServiceException {
        return DaoFactory.clientDao().update(c);
    }
}
