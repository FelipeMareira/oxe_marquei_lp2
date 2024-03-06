package Model.Entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Query {
    private LocalDate dateOfAppointment;
    private LocalDateTime timeOfAppointment;
    private String address;

    public Query(LocalDate dateOfAppointment, LocalDateTime timeOfAppointment, String address) {
        this.dateOfAppointment = dateOfAppointment;
        this.timeOfAppointment = timeOfAppointment;
        this.address = address;
    }
    @Override
    public String toString() {
        return "Query{" +
                "dateOfAppointment=" + dateOfAppointment +
                ", timeOfAppointment=" + timeOfAppointment +
                ", address='" + address + '\'' +
                '}';
    }
}
