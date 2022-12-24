package ba.unsa.etf.rpr.exceptions;

public class ServiceException extends Exception{
    public ServiceException(String msg, Exception reason){
        super(msg, reason);
    }

    public ServiceException(String msg){
        super(msg);
    }
}
