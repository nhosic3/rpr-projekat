package ba.unsa.etf.rpr;

import java.util.Date;

public class Service {
    private String service_id;
    private String service_type;
    private int price;
    private Date start_time;
    private Date end_time;
    private String client_id;

    public Service(String service_id, String service_type, int price, Date start_time, Date end_time, String client_id) {
        this.service_id = service_id;
        this.service_type = service_type;
        this.price = price;
        this.start_time = start_time;
        this.end_time = end_time;
        this.client_id = client_id;
    }
}
