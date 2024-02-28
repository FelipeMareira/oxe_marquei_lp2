package Model;

public class Forwarding {
    private String nameOfRequestDoctor;
    private String CRM;
    private String request;

    public Forwarding(String nameOfRequestDoctor, String CRM, String request) {
        this.nameOfRequestDoctor = nameOfRequestDoctor;
        this.CRM = CRM;
        this.request = request;
    }

    @Override
    public String toString() {
        return "Forwarding{" +
                "nameOfRequestDoctor='" + nameOfRequestDoctor + '\'' +
                ", CRM='" + CRM + '\'' +
                ", request='" + request + '\'' +
                '}';
    }

    public String getNameOfRequestDoctor() {
        return nameOfRequestDoctor;
    }

    public void setNameOfRequestDoctor(String nameOfRequestDoctor) {
        this.nameOfRequestDoctor = nameOfRequestDoctor;
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
}
