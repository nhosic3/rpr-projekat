package ba.unsa.etf.rpr;

import static org.junit.Assert.assertTrue;

import ba.unsa.etf.rpr.business.ClientManager;
import ba.unsa.etf.rpr.business.EmployeeManager;
import ba.unsa.etf.rpr.business.ServiceManager;
import ba.unsa.etf.rpr.domain.Client;
import ba.unsa.etf.rpr.domain.Employee;
import ba.unsa.etf.rpr.domain.Service;
import ba.unsa.etf.rpr.exceptions.ServiceException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Unit test for App.
 */
public class AppFXTest {
    ClientManager cm = new ClientManager();
    EmployeeManager em = new EmployeeManager();
    ServiceManager sm = new ServiceManager();
    @Test
    void searchByIdTest1() throws ServiceException {
        List<Service> l = sm.getAll();
        Service t1 = l.get(0);
        int id = t1.getID();
        Service t2 = sm.searchById(id);
        Assertions.assertEquals(t1, t2);
    }
    @Test
    void searchByIdTest2() throws ServiceException {
        List<Client> l = cm.getAll();
        Client t1 = l.get(0);
        int id = t1.getID();
        Client t2 = cm.searchById(id);
        Assertions.assertEquals(t1, t2);
    }
    @Test
    void searchByIdTest3() throws ServiceException {
        List<Employee> l = em.getAll();
        Employee t1 = l.get(0);
        int id = t1.getID();
        Employee t2 = em.searchById(id);
        Assertions.assertEquals(t1, t2);
    }
}
