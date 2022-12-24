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
    public Map<String, Object> object2row(Client object) {
        Map<String, Object> item = new TreeMap<String, Object>();
        item.put("id", object.getId());
        item.put("first_name", object.getFirst_name());
        item.put("last_name", object.getLast_name());
        item.put("phone_number", object.getPhone_number());
        item.put("email", object.getEmail());
        item.put("paid", object.isPaid());
        return item;
    }

    @Override
    public List<Client> searchByName(String name) throws ServiceException{
        String query = "SELECT * FROM Tickets WHERE first_name = ?";
        List<Client> list = new ArrayList<>();
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
