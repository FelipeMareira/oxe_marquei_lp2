package Model.Entities;

import java.time.LocalDateTime;
public class Query {

    private Integer idQuery;
    private String nameOfConsultationDoctor;
    private String CRMConsultationDoctor;
    private String officeAddress;

    private LocalDateTime dateAndTimeConsultation;
    private PublicAgent publicAgent;
    private Solicitation solicitation;

    public Query() {

    }

    public Query(Integer idQuery, String nameOfConsultationDoctor, String CRMConsultationDoctor, String officeAddress,
                 LocalDateTime dateAndTimeConsultation, PublicAgent publicAgent, Solicitation solicitation) {
        this.idQuery = idQuery;
        this.nameOfConsultationDoctor = nameOfConsultationDoctor;
        this.CRMConsultationDoctor = CRMConsultationDoctor;
        this.officeAddress = officeAddress;
        this.dateAndTimeConsultation = dateAndTimeConsultation;
        this.publicAgent = publicAgent;
        this.solicitation = solicitation;
    }

    public Query(String nameOfConsultationDoctor, String CRMConsultationDoctor, String officeAddress,
                 LocalDateTime dateAndTimeConsultation, PublicAgent publicAgent, Solicitation solicitation) {
        this.nameOfConsultationDoctor = nameOfConsultationDoctor;
        this.CRMConsultationDoctor = CRMConsultationDoctor;
        this.officeAddress = officeAddress;
        this.dateAndTimeConsultation = dateAndTimeConsultation;
        this.publicAgent = publicAgent;
        this.solicitation = solicitation;
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

    public String getCRMConsultationDoctor() {
        return CRMConsultationDoctor;
    }

    public void setCRMConsultationDoctor(String CRMConsultationDoctor) {
        this.CRMConsultationDoctor = CRMConsultationDoctor;
    }

    public String getOfficeAddress() {
        return officeAddress;
    }

    public void setOfficeAddress(String officeAddress) {
        this.officeAddress = officeAddress;
    }

    public LocalDateTime getDateAndTimeConsultation() {
        return dateAndTimeConsultation;
    }

    public void setDateAndTimeConsultation(LocalDateTime dateAndTimeConsultation) {
        this.dateAndTimeConsultation = dateAndTimeConsultation;
    }

    public PublicAgent getPublicAgent() {
        return publicAgent;
    }

    public void setPublicAgent(PublicAgent publicAgent) {
        this.publicAgent = publicAgent;
    }

    public Solicitation getSolicitation() {
        return solicitation;
    }

    public void setSolicitation(Solicitation solicitation) {
        this.solicitation = solicitation;
    }

    @Override
    public String toString() {
        return "Query{" +
                "idQuery=" + idQuery +
                ", nameOfConsultationDoctor='" + nameOfConsultationDoctor + '\'' +
                ", dateAndTimeConsultation=" + dateAndTimeConsultation +
                ", officeAddress='" + officeAddress + '\'' +
                ", publicAgent=" + publicAgent +
                ", solicitation=" + solicitation +
                '}';
    }
}
