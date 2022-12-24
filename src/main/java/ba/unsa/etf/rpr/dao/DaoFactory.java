package ba.unsa.etf.rpr.dao;

public class DaoFactory {
    private static final ClientDao clientDao = new ClientDaoSQLImpl();
    private static final EmployeeDao employeeDao = new EmployeeDaoSQLImpl();
    private static final ServiceDao serviceDao = new ServiceDaoSQLImpl();

    private DaoFactory(){

    }

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
