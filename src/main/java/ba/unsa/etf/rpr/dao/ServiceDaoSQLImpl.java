package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Service;
import ba.unsa.etf.rpr.exceptions.ServiceException;

import java.sql.*;
import java.util.*;
import java.sql.Date;

public class ServiceDaoSQLImpl extends AbstractDao<Service> implements ServiceDao {

    private static ServiceDaoSQLImpl instance = null;
    public ServiceDaoSQLImpl() {
        super("Service");
    }

    public static ServiceDaoSQLImpl getInstance() {
        if (instance == null)
            instance = new ServiceDaoSQLImpl();
        return instance;
    }

    public static void removeInstance() {
        if (instance != null)
            instance = null;
    }
    @Override
    public Service row2object(ResultSet rs) throws ServiceException {
        try {
            Service e = new Service();
            e.setID(rs.getInt("id"));
            e.setService_type(rs.getString("service_type"));
            e.setPrice(rs.getInt("price"));
            e.setStart_time(rs.getDate("start_time"));
            e.setEnd_time(rs.getDate("end_time"));
            e.setClient_id(rs.getInt("client_id"));
            return e;
        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public Map<String, Object> object2row(Service object) {
        Map<String, Object> m = new TreeMap<String, Object>();
        m.put("id", object.getID());
        m.put("service_type", object.getService_type());
        m.put("price", object.getPrice());
        m.put("start_time", object.getStart_time());
        m.put("end_time", object.getEnd_time());
        m.put("client_id", object.getClient_id());
        return m;
    }

    @Override
    public List<Service> searchByServiceType(String st) throws ServiceException{
        String query = "SELECT * FROM Service WHERE Service_type = ?";
        List<Service> list = new ArrayList<>();
        try {
            PreparedStatement s = getConnection().prepareStatement(query);
            s.setString(1, st);
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
    public List<Service> searchByClientId(int id) throws ServiceException{
        String query = "SELECT * FROM Service WHERE Client_id = ?";
        List<Service> list = new ArrayList<>();
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
    public List<Service> searchByStartTime(java.util.Date st) throws ServiceException{
        String query = "SELECT * FROM Service WHERE Start_time = ?";
        List<Service> list = new ArrayList<>();
        try {
            PreparedStatement s = getConnection().prepareStatement(query);
            s.setDate(1, (Date) st);
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
    public List<Service> searchByEndTime(java.util.Date et) throws ServiceException{
        String query = "SELECT * FROM Service WHERE End_time = ?";
        List<Service> list = new ArrayList<>();
        try {
            PreparedStatement s = getConnection().prepareStatement(query);
            s.setDate(1, (Date) et);
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
