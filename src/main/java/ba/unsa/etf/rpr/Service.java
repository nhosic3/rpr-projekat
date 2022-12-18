package ba.unsa.etf.rpr;

import java.util.Date;
import java.util.Objects;

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

    public String getService_id() {
        return service_id;
    }

    public void setService_id(String service_id) {
        this.service_id = service_id;
    }

    public String getService_type() {
        return service_type;
    }

    public void setService_type(String service_type) {
        this.service_type = service_type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getStart_time() {
        return start_time;
    }

    public void setStart_time(Date start_time) {
        this.start_time = start_time;
    }

    public Date getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Date end_time) {
        this.end_time = end_time;
    }

    public String getClient_id() {
        return client_id;
    }

    public void setClient_id(String client_id) {
        this.client_id = client_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Service service = (Service) o;
        return price == service.price && Objects.equals(service_id, service.service_id) && Objects.equals(service_type, service.service_type) && Objects.equals(start_time, service.start_time) && Objects.equals(end_time, service.end_time) && Objects.equals(client_id, service.client_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(service_id, service_type, price, start_time, end_time, client_id);
    }
}
