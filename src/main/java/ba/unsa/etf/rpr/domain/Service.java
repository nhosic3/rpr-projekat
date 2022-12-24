package ba.unsa.etf.rpr.domain;

import java.util.Date;
import java.util.Objects;

/**
 * Service data
 */
public class Service implements Idable{
    private int id;
    private String service_type;
    private int price;
    private Date start_time;
    private Date end_time;
    private int client_id;

    public Service(){

    }

    public Service(int id, String service_type, int price, Date start_time, Date end_time, int client_id) {
        this.id = id;
        this.service_type = service_type;
        this.price = price;
        this.start_time = start_time;
        this.end_time = end_time;
        this.client_id = client_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Service service = (Service) o;
        return id == service.id && price == service.price && client_id == service.client_id && Objects.equals(service_type, service.service_type) && Objects.equals(start_time, service.start_time) && Objects.equals(end_time, service.end_time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, service_type, price, start_time, end_time, client_id);
    }

    @Override
    public String toString() {
        return "Service{" +
                "id=" + id +
                ", service_type='" + service_type + '\'' +
                ", price=" + price +
                ", start_time=" + start_time +
                ", end_time=" + end_time +
                ", client_id=" + client_id +
                '}';
    }
}
