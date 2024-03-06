package Model.Entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Citizen extends Person {
    private String email;
    private List<Forwarding> forwardings = new ArrayList<>();
    public Citizen(String name, int age, String CPF, String RG, String phoneNumber1,
                   String phoneNumber2, LocalDate dateOfBirth, String address, String email) {
        super(name, age, CPF, RG, phoneNumber1, phoneNumber2, dateOfBirth, address);
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Forwarding> getForwardings() {
        return forwardings;
    }

    public void addForwarding(Forwarding forwarding) {
        this.forwardings.add(forwarding);
    }

    @Override
    public String toString() {
        return "Citizen{" +
                "email='" + email + '\'' +
                ", forwardings=" + forwardings +
                '}';
    }
}
