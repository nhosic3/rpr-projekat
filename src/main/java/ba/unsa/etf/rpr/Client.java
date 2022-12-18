package ba.unsa.etf.rpr;

import java.util.Date;
import java.util.Objects;

public class Client {
    private String client_id;
    private String first_name, last_name;
    private String phone_number;
    private String email;
    private boolean paid;

    public Client(String client_id, String first_name, String last_name, String phone_number, String email, boolean paid) {
        this.client_id = client_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.phone_number = phone_number;
        this.email = email;
        this.paid = paid;
    }

    public String getClient_id() {
        return client_id;
    }

    public void setClient_id(String client_id) {
        this.client_id = client_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return paid == client.paid && Objects.equals(client_id, client.client_id) && Objects.equals(first_name, client.first_name) && Objects.equals(last_name, client.last_name) && Objects.equals(phone_number, client.phone_number) && Objects.equals(email, client.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(client_id, first_name, last_name, phone_number, email, paid);
    }
}
