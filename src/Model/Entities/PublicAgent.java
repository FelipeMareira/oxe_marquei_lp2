package Model.Entities;

import Model.Entities.Citizen;
import Model.Entities.Person;

import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PublicAgent extends Person {


    private Integer idPublicAgent;
    private String email;
    private String user;
    private String password;
    private String typeUser;

    public PublicAgent(){}
    public PublicAgent(Integer idPublicAgent, String name, String CPF, String RG, String phoneNumber1,
                       String phoneNumber2, LocalDate dateOfBirth, String address, String email,
                       String user, String password, String typeUser) {
        super(name, CPF, RG, phoneNumber1, phoneNumber2, dateOfBirth, address);
        this.idPublicAgent = idPublicAgent;
        this.email = email;
        this.user = user;
        this.password = password;
        this.typeUser = typeUser;
    }

    public PublicAgent(Integer idPublicAgent, String name, String CPF, String RG, String phoneNumber1,
                       String phoneNumber2, LocalDate dateOfBirth, String address, String email) {
        super(name, CPF, RG, phoneNumber1, phoneNumber2, dateOfBirth, address);
        this.idPublicAgent = idPublicAgent;
        this.email = email;
    }

    public Integer getIdPublicAgent() {
        return idPublicAgent;
    }

    public void setIdPublicAgent(Integer idPublicAgent) {
        this.idPublicAgent = idPublicAgent;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTypeUser() {
        return typeUser;
    }

    public void setTypeUser(String typeUser) {
        this.typeUser = typeUser;
    }
}
