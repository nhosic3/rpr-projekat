package ba.unsa.etf.rpr;

import java.util.Date;

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
}
