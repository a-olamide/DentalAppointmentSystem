package model;

import java.time.LocalDateTime;

public class Appointment {
    private String appointmentID;
    private LocalDateTime appointmentDate;

    public Appointment(String appointmentID, LocalDateTime appointmentDate) {
        this.appointmentID = appointmentID;
        this.appointmentDate = appointmentDate;
    }

    public String getAppointmentID() {
        return appointmentID;
    }

    public void setAppointmentID(String appointmentID) {
        this.appointmentID = appointmentID;
    }

    public LocalDateTime getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDateTime appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "appointmentID='" + appointmentID + '\'' +
                ", appointmentDate=" + appointmentDate +
                '}';
    }
}
