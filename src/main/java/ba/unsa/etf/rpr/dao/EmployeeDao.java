package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Employee;
import ba.unsa.etf.rpr.exceptions.ServiceException;

import java.util.List;

public interface EmployeeDao extends Dao<Employee> {

    /**
     * Searches employees by ID
     */
    List<Employee> searchByServiceId(int id) throws ServiceException;

    /**
     * Searches employees by ID
     */
    List<Employee> searchByName(String name) throws ServiceException;
}