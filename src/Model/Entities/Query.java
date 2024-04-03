package Model.Entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
public class Query {

    private Integer idQuery;
    private String nameOfConsultationDoctor;
    private LocalDateTime dateAndTimeConsultation;
    private String officeAddress;
    private PublicAgent publicAgent;
    private Forwarding forwarding;

    public Query() {

    }

    public Query(Integer idQuery, String nameOfConsultationDoctor, LocalDateTime dateAndTimeConsultation,
                 String officeAddress, PublicAgent publicAgent, Forwarding forwarding) {
        this.idQuery = idQuery;
        this.nameOfConsultationDoctor = nameOfConsultationDoctor;
        this.dateAndTimeConsultation = dateAndTimeConsultation;
        this.officeAddress = officeAddress;
        this.publicAgent = publicAgent;
        this.forwarding = forwarding;
    }
    public Query(String nameOfConsultationDoctor, LocalDateTime dateAndTimeConsultation,
                 String officeAddress, PublicAgent publicAgent, Forwarding forwarding) {

        this.nameOfConsultationDoctor = nameOfConsultationDoctor;
        this.dateAndTimeConsultation = dateAndTimeConsultation;
        this.officeAddress = officeAddress;
        this.publicAgent = publicAgent;
        this.forwarding = forwarding;
    }

    public Integer getIdQuery() {
        return idQuery;
    }

    public void setIdQuery(Integer idQuery) {
        this.idQuery = idQuery;
    }

    public String getNameOfConsultationDoctor() {
        return nameOfConsultationDoctor;
    }

    public void setNameOfConsultationDoctor(String nameOfConsultationDoctor) {
        this.nameOfConsultationDoctor = nameOfConsultationDoctor;
    }

    public LocalDateTime getDateAndTimeConsultation() {
        return dateAndTimeConsultation;
    }

    public void setDateAndTimeConsultation(LocalDateTime dateAndTimeConsultation) {
        this.dateAndTimeConsultation = dateAndTimeConsultation;
    }

    public String getOfficeAddress() {
        return officeAddress;
    }

    public void setOfficeAddress(String officeAddress) {
        this.officeAddress = officeAddress;
    }

    public PublicAgent getPublicAgent() {
        return publicAgent;
    }

    public void setPublicAgent(PublicAgent publicAgent) {
        this.publicAgent = publicAgent;
    }

    public Forwarding getForwarding() {
        return forwarding;
    }

    public void setForwarding(Forwarding forwarding) {
        this.forwarding = forwarding;
    }

    @Override
    public String toString() {
        return "Query{" +
                "idQuery=" + idQuery +
                ", nameOfConsultationDoctor='" + nameOfConsultationDoctor + '\'' +
                ", dateAndTimeConsultation=" + dateAndTimeConsultation +
                ", officeAddress='" + officeAddress + '\'' +
                ", publicAgent=" + publicAgent +
                ", forwarding=" + forwarding +
                '}';
    }
}
