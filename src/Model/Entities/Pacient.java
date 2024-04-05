package Model.Entities;

import java.time.LocalDate;

public class Pacient extends Person {

    private int idPacient;
    private String email;
    private String SIGTAP;

    public Pacient() {

    }
    public Pacient(int idPacient, String name, String CPF, String RG, String phoneNumber1,
                   String phoneNumber2, LocalDate dateOfBirth, String address, String email, String SIGTAP) {
        super(name, CPF, RG, phoneNumber1, phoneNumber2, dateOfBirth, address);
        this.idPacient = idPacient;
        this.email = email;
        this.SIGTAP = SIGTAP;
    }

    public Pacient(String name, String CPF, String RG, String phoneNumber1,
                   String phoneNumber2, LocalDate dateOfBirth, String address, String email, String SIGTAP) {
        super(name, CPF, RG, phoneNumber1, phoneNumber2, dateOfBirth, address);
        this.email = email;
        this.SIGTAP = SIGTAP;
    }
    public Pacient(String name, String CPF, String RG, String phoneNumber1,
                   LocalDate dateOfBirth, String address, String email, String SIGTAP) {
        super(name, CPF, RG, phoneNumber1, dateOfBirth, address);
        this.email = email;
        this.SIGTAP = SIGTAP;
    }

    public int getIdPacient() {
        return idPacient;
    }

    public void setIdPacient(int idPacient) {
        this.idPacient = idPacient;
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

    @Override
    public String toString() {
        return "Citizen{" +
                "  idPacient=" + idPacient +
                ", email='" + email + '\'' +
                ", SIGTAP='" + SIGTAP + '\'' +
                '}';
    }
}
