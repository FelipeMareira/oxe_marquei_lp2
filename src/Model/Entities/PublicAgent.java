package Model.Entities;

import Model.Entities.Citizen;
import Model.Entities.Person;

import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PublicAgent extends Person {
    private String code;
    private LocalDateTime workTime;

    private List<Citizen> citizens = new ArrayList<>();
    public PublicAgent(String name, int age, String CPF, String RG, String phoneNumber1,
                       String phoneNumber2, LocalDate dateOfBirth, String address,
                       String code, LocalDateTime workTime) {
        super(name, age, CPF, RG, phoneNumber1, phoneNumber2, dateOfBirth, address);
        this.code = code;
        this.workTime = workTime;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LocalDateTime getWorkTime() {
        return workTime;
    }

    public void setWorkTime(LocalDateTime workTime) {
        this.workTime = workTime;
    }

    public void addCitizen(Citizen citizen) {
        this.citizens.add(citizen);
    }
}
