package ba.unsa.etf.rpr;

import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

public interface EmployeeDao extends Dao<Employee>{
    /**
     * Searches employees by names
     */
    List<Employee> searchByName(String name);

    /**
     * Searches employees by ID
     */
    List<Employee> searchById(String id);
}
