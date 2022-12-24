package ba.unsa.etf.rpr;

import ba.unsa.etf.rpr.domain.Client;
import ba.unsa.etf.rpr.dao.ClientDaoSQLImpl;
import ba.unsa.etf.rpr.domain.Service;
import ba.unsa.etf.rpr.domain.Employee;
import ba.unsa.etf.rpr.exceptions.ServiceException;

import java.io.File;
import java.io.FileInputStream;
import java.util.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        try{
            ClientDaoSQLImpl c = new ClientDaoSQLImpl();
            Client cc = new Client();
            cc.setPhone_number("12345679");
            cc.setPaid(true);
            //cc.setID(1324);
            cc.setEmail("asdasd@gmail.com");
            cc.setFirst_name("Nedim");
            cc.setLast_name("Hosic");
            c.add(cc);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
