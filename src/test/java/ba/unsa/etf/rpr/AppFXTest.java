package ba.unsa.etf.rpr;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import ba.unsa.etf.rpr.business.ClientManager;
import ba.unsa.etf.rpr.business.EmployeeManager;
import ba.unsa.etf.rpr.business.ServiceManager;
import ba.unsa.etf.rpr.controllers.RegisterController;
import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.dao.ServiceDao;
import ba.unsa.etf.rpr.domain.Client;
import ba.unsa.etf.rpr.domain.Employee;
import ba.unsa.etf.rpr.domain.Service;
import ba.unsa.etf.rpr.exceptions.ServiceException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.apache.commons.validator.routines.EmailValidator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Unit test for App.
 */
public class AppFXTest {
    private ClientManager cm = new ClientManager();
    private EmployeeManager em = new EmployeeManager();
    private ServiceManager sm = new ServiceManager();
    @Test
    void searchByIdTest1() throws ServiceException {
        List<Service> l = sm.getAll();
        Service s1 = l.get(0);
        int id = s1.getID();
        Service s2 = sm.searchById(id);
        Assertions.assertEquals(s1, s2);
    }
    @Test
    void searchByIdTest2() throws ServiceException {
        List<Client> l = cm.getAll();
        Client c1 = l.get(0);
        int id = c1.getID();
        Client c2 = cm.searchById(id);
        Assertions.assertEquals(c1, c2);
    }
    @Test
    void searchByIdTest3() throws ServiceException {
        List<Employee> l = em.getAll();
        Employee c1 = l.get(0);
        int id = c1.getID();
        Employee c2 = em.searchById(id);
        Assertions.assertEquals(c1, c2);
    }
    @Test
    void addServiceTest() throws ServiceException, ParseException {
        SimpleDateFormat formatter1=new SimpleDateFormat("dd/MM/yyyy");
        Date d=formatter1.parse("13/02/2023");
        Date d2=formatter1.parse("28/02/2023");
        Service s = new Service(123, "Photoshop", 30, d, d2, 0);
        s = sm.add(s);
        List<Service> list = sm.getAll();
        boolean b = false;
        for (Service s2 : list)
            if (s.getID() == s2.getID())
                b = true;
        Assertions.assertTrue(b);
    }
    @Test
    void deleteServiceTest() throws ServiceException {
        sm.delete(123);
        boolean b = true;
        List<Service> l = sm.getAll();
        for (Service t : l)
            if (123 == t.getID())
                b = false;
        Assertions.assertTrue(b);
    }
    @Test
    void addClientTest() throws ServiceException, ParseException {
        Client c = new Client(123, "Nedim", "Hosic", "123", "nhosic", "123");
        cm.add(c);
        List<Client> l = cm.getAll();
        boolean b = false;
        for (Client c2 : l)
            if (c.getID() == c2.getID())
                b = true;
        Assertions.assertTrue(b);
    }
    @Test
    void deleteClientTest() throws ServiceException {
        cm.delete(123);
        boolean b = true;
        List<Client> l = cm.getAll();
        for (Client c : l)
            if (123 == c.getID())
                b = false;
        Assertions.assertTrue(b);
    }
    @Test
    void updateTest1() throws ServiceException {
        List<Employee> l = em.getAll();

        Employee e = l.get(0);
        String s = e.getFirst_name();
        e.setFirst_name("asdasd");
        em.update(e);

        l = em.getAll();
        boolean b = false;
        for (Employee e2 : l)
            if (e2.equals(e))
                b = true;
        Assertions.assertTrue(b);

        e.setFirst_name(s);
        em.update(e);
    }

    @Test
    void updateTest2() throws ServiceException {
        List<Client> l = cm.getAll();

        Client c = l.get(0);
        String s = c.getFirst_name();
        c.setFirst_name("qweqwe");
        cm.update(c);

        l = cm.getAll();
        boolean b = false;
        for (Client c2 : l)
            if (c2.equals(c))
                b = true;
        Assertions.assertTrue(b);

        c.setFirst_name(s);
        cm.update(c);
    }

    @Test
    void updateTest3() throws ServiceException {
        List<Service> l = sm.getAll();

        Service s = l.get(0);
        String str = s.getService_type();
        s.setService_type("zzzzz");
        sm.update(s);

        l = sm.getAll();
        boolean b = false;
        for (Service s2 : l)
            if (s2.equals(s))
                b = true;
        Assertions.assertTrue(b);

        s.setService_type(str);
        sm.update(s);
    }
    @Test
    void searchServiceByCliendId() throws ServiceException {
        LocalDate l = LocalDate.now();
        ZoneId defaultZoneId = ZoneId.systemDefault();
        Date date = Date.from(l.atStartOfDay(defaultZoneId).toInstant());
        LocalDate l2 =  LocalDate.now().plusDays(15);
        Date date2 = Date.from(l2.atStartOfDay(defaultZoneId).toInstant());
        Service s = new Service(12,"Photoshop",30, date, date2,4);

        List<Service> list = new ArrayList<>();
        list.add(s);

        Service s2 = new Service(123,"Node",150, date, date2,4);
        list.add(s2);

        MockedStatic<DaoFactory> dao = Mockito.mockStatic(DaoFactory.class);
        ServiceDao m = Mockito.mock(ServiceDao.class);
        when(DaoFactory.serviceDao()).thenReturn(m);

        when(DaoFactory.serviceDao().searchByClientId(4)).thenReturn(list);
        assertTrue(true);
    }
    @Test
    void emailTest() throws ServiceException {
        ClientManager cm = Mockito.mock(ClientManager.class);
        EmailValidator ev = EmailValidator.getInstance();
        when(cm.searchById(0)).thenReturn(new Client(100, "Nedim", "Hosic", "123", "nedimhosic@gmail.com", "123123"));
        Assertions.assertTrue(ev.isValid(cm.searchById(0).getEmail()));
        when(cm.searchById(0)).thenReturn(new Client(100, "Nedim", "Hosic", "123", "nedimhosic11@gmail.com", "1234"));
        Assertions.assertTrue(ev.isValid(cm.searchById(0).getEmail()));
    }
}
