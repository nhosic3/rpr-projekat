package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.Client;
import ba.unsa.etf.rpr.domain.Employee;
import ba.unsa.etf.rpr.exceptions.ServiceException;

import java.util.List;

public class EmployeeManager {
    public Employee searchById(int id) throws ServiceException {
        return DaoFactory.employeeDao().searchById(id);
    }

    public List<Employee> searchByServiceId(int s_id) throws ServiceException {
        return DaoFactory.employeeDao().searchByServiceId(s_id);
    }
    public Employee add(Employee e) throws ServiceException {
        return DaoFactory.employeeDao().add(e);
    }

    public List<Employee> getAll() throws ServiceException {
        return DaoFactory.employeeDao().getAll();
    }

    public Employee update(Employee e) throws ServiceException {
        return DaoFactory.employeeDao().update(e);
    }

    public void delete(int id) throws ServiceException {
        DaoFactory.employeeDao().delete(id);
    }
}
