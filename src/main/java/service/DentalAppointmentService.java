package service;

import model.Appointment;
import repository.AppointmentRepository;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;

public class DentalAppointmentService {
    private final AppointmentRepository appointmentRepository;
    public DentalAppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }
    public void addAppointment(Appointment appointment) {
        appointmentRepository.addAppointment(appointment);
    }
    public List<Appointment> generateAppointmentsReport(int year, int quarter) {
        int startMonth = (quarter - 1) * 3 + 1;
        LocalDateTime start = LocalDateTime.of(year, startMonth, 1, 0, 0);
        LocalDateTime end = start.plusMonths(3);

        return appointmentRepository.getAppointments().stream()
                .filter(a -> {
                    LocalDateTime dt = a.getAppointmentDate();
                    return !dt.isBefore(start) && dt.isBefore(end);
                }).sorted(Comparator.comparing(Appointment::getAppointmentDate).reversed())
                .toList();

    }
}
