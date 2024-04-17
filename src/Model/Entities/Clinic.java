package Model.Entities;

public class Clinic {
    int idClinic;
    String nameOfClinic;
    String address;

    public Clinic(int idClinic, String nameOfClinic, String address) {
        this.idClinic = idClinic;
        this.nameOfClinic = nameOfClinic;
        this.address = address;
    }

    public Clinic(String nameOfClinic, String address) {
        this.nameOfClinic = nameOfClinic;
        this.address = address;
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

    @Override
    public String toString() {
        return "Clinic{" +
                "idClinic=" + idClinic +
                ", nameOfClinic='" + nameOfClinic + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
