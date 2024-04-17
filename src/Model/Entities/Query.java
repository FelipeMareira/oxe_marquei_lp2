package Model.Entities;

import java.time.LocalDateTime;
public class Query {

    private Integer idQuery;
    private Solicitation solicitation;
    private PublicAgent publicAgent;
    private Clinic clinic;
    private LocalDateTime dateAndTimeConsultation;

    public Query() {

    }

    public Query(Integer idQuery, Solicitation solicitation, PublicAgent publicAgent,
                 Clinic clinic, LocalDateTime dateAndTimeConsultation) {
        this.idQuery = idQuery;
        this.solicitation = solicitation;
        this.publicAgent = publicAgent;
        this.clinic = clinic;
        this.dateAndTimeConsultation = dateAndTimeConsultation;
    }

    public Query(Solicitation solicitation, PublicAgent publicAgent,
                 Clinic clinic, LocalDateTime dateAndTimeConsultation) {
        this.solicitation = solicitation;
        this.publicAgent = publicAgent;
        this.clinic = clinic;
        this.dateAndTimeConsultation = dateAndTimeConsultation;
    }

    public Integer getIdQuery() {
        return idQuery;
    }

    public void setIdQuery(Integer idQuery) {
        this.idQuery = idQuery;
    }

    public Solicitation getSolicitation() {
        return solicitation;
    }

    public void setSolicitation(Solicitation solicitation) {
        this.solicitation = solicitation;
    }

    public PublicAgent getPublicAgent() {
        return publicAgent;
    }

    public void setPublicAgent(PublicAgent publicAgent) {
        this.publicAgent = publicAgent;
    }

    public Clinic getClinic() {
        return clinic;
    }

    public void setClinic(Clinic clinic) {
        this.clinic = clinic;
    }

    public LocalDateTime getDateAndTimeConsultation() {
        return dateAndTimeConsultation;
    }

    public void setDateAndTimeConsultation(LocalDateTime dateAndTimeConsultation) {
        this.dateAndTimeConsultation = dateAndTimeConsultation;
    }

    @Override
    public String toString() {
        return "Query{" +
                "idQuery=" + idQuery +
                ", solicitation=" + solicitation +
                ", publicAgent=" + publicAgent +
                ", clinic=" + clinic +
                ", dateAndTimeConsultation=" + dateAndTimeConsultation +
                '}';
    }
}
