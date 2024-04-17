package Model.Entities;

public class Clinic {
    int idClinic;
    String nameOfClinic;
    String address;
    String status;

    public Clinic(int idClinic, String nameOfClinic, String address, String status) {
        this.idClinic = idClinic;
        this.nameOfClinic = nameOfClinic;
        this.address = address;
        this.status = status;
    }

    public int getIdClinic() {
        return idClinic;
    }

    public void setIdClinic(int idClinic) {
        this.idClinic = idClinic;
    }

    public String getNameOfClinic() {
        return nameOfClinic;
    }

    public void setNameOfClinic(String nameOfClinic) {
        this.nameOfClinic = nameOfClinic;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Clinic{" +
                "idClinic=" + idClinic +
                ", nameOfClinic='" + nameOfClinic + '\'' +
                ", address='" + address + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
