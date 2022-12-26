package ba.unsa.etf.rpr.domain;

import java.util.Objects;

/**
 * Client data
 */
public class Client implements Idable {
    private int ID;
    private String first_name, last_name;
    private String phone_number;
    private String email;
    private String password;
    private boolean paid;

    public Client(){

    }
    public Client(int ID, String first_name, String last_name, String phone_number, String email, String password, boolean paid) {
        this.ID = ID;
        this.first_name = first_name;
        this.last_name = last_name;
        this.phone_number = phone_number;
        this.email = email;
        this.password = password;
        this.paid = paid;
    }

    @Override
    public int getID() {
        return ID;
    }

    @Override
    public void setID(int ID) {
        this.ID = ID;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
        return ID == client.ID && paid == client.paid && Objects.equals(first_name, client.first_name) && Objects.equals(last_name, client.last_name) && Objects.equals(phone_number, client.phone_number) && Objects.equals(email, client.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, first_name, last_name, phone_number, email, paid);
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + ID +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", phone_number='" + phone_number + '\'' +
                ", email='" + email + '\'' +
                ", paid=" + paid +
                '}';
    }
}
