package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Employee;
import ba.unsa.etf.rpr.domain.Service;
import ba.unsa.etf.rpr.exceptions.ServiceException;

import java.sql.*;
import java.util.*;

public class ServiceDaoSQLImpl extends AbstractDao<Service> implements ServiceDao {

    public ServiceDaoSQLImpl() {
        super("services");
    }

    @Override
    public Service row2object(ResultSet rs) throws ServiceException {
        try {
            Service e = new Service();
            e.setId(rs.getInt("id"));
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
        Map<String, Object> item = new TreeMap<String, Object>();
        item.put("id", object.getId());
        item.put("service_type", object.getService_type());
        item.put("price", object.getPrice());
        item.put("start_time", object.getStart_time());
        item.put("end_time", object.getEnd_time());
        item.put("client_id", object.getClient_id());
        return item;
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
}