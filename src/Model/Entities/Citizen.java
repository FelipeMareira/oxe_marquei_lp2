package Model.Entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Citizen extends Person {
    private String email;
    private String SIGTAP;
    public Citizen(String name, String CPF, String RG, String phoneNumber1,
                   String phoneNumber2, LocalDate dateOfBirth, String address, String email, String SIGTAP) {
        super(name, CPF, RG, phoneNumber1, phoneNumber2, dateOfBirth, address);
        this.email = email;
        this.SIGTAP = SIGTAP;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSIGTAP() {
        return SIGTAP;
    }

    public void setSIGTAP(String SIGTAP) {
        this.SIGTAP = SIGTAP;
    }
}
