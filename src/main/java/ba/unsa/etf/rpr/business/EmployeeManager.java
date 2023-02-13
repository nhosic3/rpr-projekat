package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.Employee;
import ba.unsa.etf.rpr.exceptions.ServiceException;

import java.util.List;

public class EmployeeManager {
    /**
     * A method which searches employees by their id
     * @return employee with given id
     */
    public Employee searchById(int id) throws ServiceException {
        return DaoFactory.employeeDao().searchById(id);
    }
    /**
     * A method which searches employees by their service id
     * @return list of all employees with given service id
     */
    public List<Employee> searchByServiceId(int s_id) throws ServiceException {
        return DaoFactory.employeeDao().searchByServiceId(s_id);
    }
    /**
     * A method which adds employee to database
     * @return employee if added correctly
     */
    public Employee add(Employee e) throws ServiceException {
        return DaoFactory.employeeDao().add(e);
    }
    /**
     * A method which creates list of all employees
     * @return list of all employees
     */
    public List<Employee> getAll() throws ServiceException {
        return DaoFactory.employeeDao().getAll();
    }
    /**
     * A method which deletes employee by given id
     * @return employee if deleted correctly
     */
    public void delete(int id) throws ServiceException {
        DaoFactory.employeeDao().delete(id);
    }
    /**
     * A method which updates employee
     * @return employee if updated correctly
     */
    public Employee update(Employee e) throws ServiceException {
        return DaoFactory.employeeDao().update(e);
    }
}
