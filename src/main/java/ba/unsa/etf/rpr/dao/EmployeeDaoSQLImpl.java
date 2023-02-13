package ba.unsa.etf.rpr.dao;
import ba.unsa.etf.rpr.domain.Employee;
import ba.unsa.etf.rpr.domain.Service;
import ba.unsa.etf.rpr.exceptions.ServiceException;

import java.sql.*;
import java.util.*;
/**
 * MySQL implementation for EmployeeDao
 */
public class EmployeeDaoSQLImpl extends AbstractDao<Employee> implements EmployeeDao {

    private static EmployeeDaoSQLImpl instance = null;
    public EmployeeDaoSQLImpl() {
        super("Employee");
    }

    public static EmployeeDaoSQLImpl getInstance() {
        if (instance == null)
            instance = new EmployeeDaoSQLImpl();
        return instance;
    }

    public static void removeInstance() {
        if (instance != null)
            instance = null;
    }
    @Override
    public Employee row2object(ResultSet rs) throws ServiceException {
        try {
            Employee e = new Employee();
            e.setID(rs.getInt("id"));
            e.setFirst_name(rs.getString("first_name"));
            e.setLast_name(rs.getString("last_name"));
            e.setBirth_date(rs.getDate("birth_date"));
            e.setHire_date(rs.getDate("hire_date"));
            e.setSalary(rs.getInt("salary"));
            e.setService_id(rs.getInt("service_id"));
            return e;
        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public Map<String, Object> object2row(Employee object) {
        Map<String, Object> m = new TreeMap<String, Object>();
        m.put("id", object.getID());
        m.put("first_name", object.getFirst_name());
        m.put("last_name", object.getLast_name());
        m.put("birth_date", object.getBirth_date());
        m.put("hire_date", object.getHire_date());
        m.put("salary", object.getSalary());
        m.put("service_id", object.getService_id());
        return m;
    }

    @Override
    public Employee searchById(int id) throws ServiceException{
        List<Employee> l = null;
        try {
            l = this.getAll();
        } catch (ServiceException e) {
            System.out.println(e.getMessage());
        }
        for(Employee e : l){
            if (e.getID() == id)
                return e;
        }
        return null;
    }
    @Override
    public List<Employee> searchByServiceId(int s_id) throws ServiceException{
        String query = "SELECT * FROM Employee WHERE service_id = ?";
        List<Employee> list = new ArrayList<>();
        try {
            PreparedStatement s = getConnection().prepareStatement(query);
            s.setInt(1, s_id);
            ResultSet rs = s.executeQuery();
            while (rs.next()) {
                list.add(row2object(rs));
            }
            rs.close();
        } catch (SQLException e) {
            throw new ServiceException(e.getMessage(), e);
        }
        return list;
    }

    @Override
    public List<Employee> searchByName(String name) throws ServiceException{
        String query = "SELECT * FROM Employee WHERE first_name = ?";
        List<Employee> list = new ArrayList<>();
        try {
            PreparedStatement s = getConnection().prepareStatement(query);
            s.setString(1, name);
            ResultSet rs = s.executeQuery();
            while (rs.next()) {
                list.add(row2object(rs));
            }
            rs.close();
        } catch (SQLException e) {
            throw new ServiceException(e.getMessage(), e);
        }
        return list;
    }
}
