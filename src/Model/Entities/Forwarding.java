package Model.Entities;

public class Forwarding {
    private Integer idForwarding;
    private String CRM;
    private String request;
    private String nameOfRequestDoctor;
    private Citizen citizen;

    public Forwarding() {

    }
    public Forwarding(Integer idForwarding, String CRM, String request, String nameOfRequestDoctor, Citizen citizen) {
        this.idForwarding = idForwarding;
        this.CRM = CRM;
        this.request = request;
        this.nameOfRequestDoctor = nameOfRequestDoctor;
        this.citizen = citizen;
    }
    public Forwarding(String CRM, String request, String nameOfRequestDoctor, Citizen citizen) {
        this.CRM = CRM;
        this.request = request;
        this.nameOfRequestDoctor = nameOfRequestDoctor;
        this.citizen = citizen;
    }

    public Integer getIdForwarding() {
        return idForwarding;
    }

    public void setIdForwarding(Integer idForwarding) {
        this.idForwarding = idForwarding;
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

    public Citizen getCitizen() {
        return citizen;
    }

    public void setCitizen(Citizen citizen) {
        this.citizen = citizen;
    }

    @Override
    public String toString() {
        return "Forwarding{" +
                "idForwarding=" + idForwarding +
                ", CRM='" + CRM + '\'' +
                ", request='" + request + '\'' +
                ", nameOfRequestDoctor='" + nameOfRequestDoctor + '\'' +
                ", citizen=" + citizen +
                '}';
    }
}
