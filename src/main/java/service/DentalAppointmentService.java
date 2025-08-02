package service;

import dto.AppointmentReportDto;
import model.Appointment;
import repository.AppointmentRepository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
    public List<AppointmentReportDto> generateAppointmentsReport(int year, int quarter) {
        int startMonth = (quarter - 1) * 3 + 1;
        LocalDateTime start = LocalDateTime.of(year, startMonth, 1, 0, 0);
        LocalDateTime end = start.plusMonths(3);

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("hh:mm a");

        return appointmentRepository.getAppointments().stream()
                .filter(a -> {
                    LocalDateTime dt = a.getAppointmentDate();
                    return !dt.isBefore(start) && dt.isBefore(end);
                }).map( a -> new AppointmentReportDto(
                                a.getAppointmentID(),
                                a.getAppointmentDate().toLocalDate().format(dateFormatter),
                                a.getAppointmentDate().toLocalTime().format(timeFormatter),
                                a.getPatient().getFirstName(),
                                a.getPatient().getLastName(),
                                a.getPatient().getPhoneNumber(),
                                a.getPatient().getDateOfBirth().toString()
                        )).sorted(Comparator.comparing(AppointmentReportDto::appointmentDate).reversed())
                .toList();
    }
}
