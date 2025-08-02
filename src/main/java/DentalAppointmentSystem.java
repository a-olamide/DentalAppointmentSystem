import dto.AppointmentReportDto;
import model.Appointment;
import model.Patient;
import repository.AppointmentRepository;
import repository.impl.AppointmentRepositoryImpl;
import service.DentalAppointmentService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class DentalAppointmentSystem {
    public static void main(String[] args) {
        AppointmentRepository repo = AppointmentRepositoryImpl.getInstance();
        DentalAppointmentService system = new DentalAppointmentService(repo);

        Patient patient1 = new Patient("1", "John","Smith", "(641) 001-1234",
                LocalDate.of(1987,1,19));
        Patient patient2 = new Patient("2", "Anna","Jones", "(641) 001-1234",
                LocalDate.of(1987,1,19));
        Patient patient3 = new Patient("3", "Carlos","Jimenez", "(641) 001-1234",
                LocalDate.of(1987,1,19));
        Patient patient4 = new Patient("4", "Albert","Einstein", "(641) 001-1234",
                LocalDate.of(1987,1,19));

        Appointment appointment1 = new Appointment("1", LocalDateTime.of(2025,2,28,10,5,0),patient1);
        Appointment appointment2 = new Appointment("2", LocalDateTime.of(2024,12,31,13,45,0),patient2);
        Appointment appointment3 = new Appointment("3", LocalDateTime.of(2025,5,4,14,0,0),patient3);
        Appointment appointment4 = new Appointment("4", LocalDateTime.of(2025,3,16,11,15,0),patient4);

        system.addAppointment(appointment1);
        system.addAppointment(appointment2);
        system.addAppointment(appointment3);
        system.addAppointment(appointment4);

        List<AppointmentReportDto> report = system.generateAppointmentsReport(2025,1);

    }
}


