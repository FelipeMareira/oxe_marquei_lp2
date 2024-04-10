package Model.Entities;

public class Solicitation {
    private Integer idSolicitation;
    private String CRM;
    private String request;
    private String nameOfRequestDoctor;
    private Patient patient;

    public Solicitation() {

    }
    public Solicitation(Integer idSolicitation, String CRM, String request, String nameOfRequestDoctor, Patient patient) {
        this.idSolicitation = idSolicitation;
        this.CRM = CRM;
        this.request = request;
        this.nameOfRequestDoctor = nameOfRequestDoctor;
        this.patient = patient;
    }
    public Solicitation(String CRM, String request, String nameOfRequestDoctor, Patient patient) {
        this.CRM = CRM;
        this.request = request;
        this.nameOfRequestDoctor = nameOfRequestDoctor;
        this.patient = patient;
    }

    public Integer getIdSolicitation() {
        return idSolicitation;
    }

    public void setIdSolicitation(Integer idSolicitation) {
        this.idSolicitation = idSolicitation;
    }

    public String getCRM() {
        return CRM;
    }

    public void setCRM(String CRM) {
        this.CRM = CRM;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public String getNameOfRequestDoctor() {
        return nameOfRequestDoctor;
    }

    public void setNameOfRequestDoctor(String nameOfRequestDoctor) {
        this.nameOfRequestDoctor = nameOfRequestDoctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    @Override
    public String toString() {
        return "Forwarding{" +
                "idSolicitation=" + idSolicitation +
                ", CRM='" + CRM + '\'' +
                ", request='" + request + '\'' +
                ", nameOfRequestDoctor='" + nameOfRequestDoctor + '\'' +
                ", pacient=" + patient +
                '}';
    }
}
