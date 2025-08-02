package repository;

import model.Appointment;

import java.util.List;

public interface AppointmentRepository {
    void addAppointment(Appointment appointment);
    List<Appointment> getAppointments();
}
