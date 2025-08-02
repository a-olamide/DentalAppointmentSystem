package repository.impl;

import model.Appointment;
import repository.AppointmentRepository;

import java.util.ArrayList;
import java.util.List;

public class AppointmentRepositoryImpl implements AppointmentRepository {
    private static AppointmentRepositoryImpl instance;
    private final List<Appointment> appointments = new ArrayList<Appointment>();
    private AppointmentRepositoryImpl() {}

public static AppointmentRepository getInstance() {
        if (instance == null || !instance.appointments.isEmpty()) {
            instance = new AppointmentRepositoryImpl();
        }
        return instance;
}
    @Override
    public void addAppointment(Appointment appointment) {
        appointments.add(appointment);
    }

    @Override
    public List<Appointment> getAppointments() {
        return appointments;
    }
}
