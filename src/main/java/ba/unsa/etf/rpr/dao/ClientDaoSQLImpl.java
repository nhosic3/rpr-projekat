package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Client;
import ba.unsa.etf.rpr.domain.Employee;
import ba.unsa.etf.rpr.exceptions.ServiceException;

import java.sql.*;
import java.util.*;
public class ClientDaoSQLImpl extends AbstractDao<Client> implements ClientDao {
    public ClientDaoSQLImpl() {
        super("clients");
    }

    @Override
    public Client row2object(ResultSet rs) throws ServiceException {
        try {
            Client e = new Client();
            e.setId(rs.getInt("id"));
            e.setFirst_name(rs.getString("first_name"));
            e.setLast_name(rs.getString("last_name"));
            e.setPhone_number(rs.getString("phone_number"));
            e.setEmail(rs.getString("email"));
            e.setPaid(rs.getBoolean("paid"));
            return e;
        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public Map<String, Object> object2row(Employee object) {
        Map<String, Object> item = new TreeMap<String, Object>();
        item.put("id", object.getId());
        item.put("first_name", object.getFirst_name());
        item.put("last_name", object.getLast_name());
        item.put("brith_date", object.getBrith_date());
        item.put("hire_date", object.getHire_date());
        item.put("salary", object.getSalary());
        item.put("service_id", object.getService_id());
        return item;
    }

    @Override
    public List<Employee> searchByServiceId(int id) throws ServiceException{
        String query = "SELECT * FROM Tickets WHERE service_id = ?";
        List<Employee> list = new ArrayList<>();
        try {
            PreparedStatement s = getConnection().prepareStatement(query);
            s.setInt(1, id);
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
        String query = "SELECT * FROM Tickets WHERE service_id = ?";
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
