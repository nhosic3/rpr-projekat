package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Client;
import ba.unsa.etf.rpr.exceptions.ServiceException;

import java.sql.*;
import java.util.*;
public class ClientDaoSQLImpl extends AbstractDao<Client> implements ClientDao {
    public ClientDaoSQLImpl() {
        super("Client");
    }

    @Override
    public Client row2object(ResultSet rs) throws ServiceException {
        try {
            Client c = new Client();
            c.setID(rs.getInt("id"));
            c.setFirst_name(rs.getString("first_name"));
            c.setLast_name(rs.getString("last_name"));
            c.setPhone_number(rs.getString("phone_number"));
            c.setEmail(rs.getString("email"));
            c.setPassword(rs.getString("password"));
            c.setPaid(rs.getBoolean("paid"));
            return c;
        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public Map<String, Object> object2row(Client object) {
        Map<String, Object> m = new TreeMap<String, Object>();
        m.put("id", object.getID());
        m.put("first_name", object.getFirst_name());
        m.put("last_name", object.getLast_name());
        m.put("phone_number", object.getPhone_number());
        m.put("email", object.getEmail());
        m.put("password", object.getPassword());
        m.put("paid", object.isPaid());
        return m;
    }

    @Override
    public List<Client> searchByName(String name) throws ServiceException{
        String query = "SELECT * FROM Client WHERE First_name = ?";
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

    @Override
    public Client searchByEmail(String email) throws ServiceException{
        List<Client> l = null;
        try {
            l = this.getAll();
        } catch (ServiceException e) {
            System.out.println(e.getMessage());
        }
        for(Client c : l){
            if (c.getEmail().equals(email))
                return c;
        }
        return null;
    }

    @Override
    public Client searchByPassword(String password) throws ServiceException{
        List<Client> l = null;
        try {
            l = this.getAll();
        } catch (ServiceException e) {
            System.out.println(e.getMessage());
        }
        for(Client c : l){
            if (c.getPassword().equals(password))
                return c;
        }
        return null;
    }
}
