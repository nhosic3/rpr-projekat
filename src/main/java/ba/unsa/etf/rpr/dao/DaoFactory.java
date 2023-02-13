package ba.unsa.etf.rpr.dao;
/**
 * Implementation of factory design pattern
 */
public class DaoFactory {
    private static final ClientDao clientDao = new ClientDaoSQLImpl();
    private static final EmployeeDao employeeDao = new EmployeeDaoSQLImpl();
    private static final ServiceDao serviceDao = new ServiceDaoSQLImpl();

    private DaoFactory(){}

    public static ClientDao clientDao(){
        return clientDao;
    }

    public static EmployeeDao employeeDao(){
        return employeeDao;
    }

    public static ServiceDao serviceDao(){
        return serviceDao;
    }
}
