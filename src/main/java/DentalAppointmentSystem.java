import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import dto.AppointmentReportDto;
import model.Appointment;
import model.Patient;
import repository.AppointmentRepository;
import repository.impl.AppointmentRepositoryImpl;
import service.DentalAppointmentService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class DentalAppointmentSystem {
    public static void main(String[] args) throws JsonProcessingException {
        Scanner scanner = new Scanner(System.in);


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
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());

        System.out.println("Welcome to the Dental Appointment Reporting System!");
        System.out.println("Type 'quit' at any time to exit.\n");

        while (true) {
            System.out.print("Enter year (e.g., 2025): ");
            String yearInput = scanner.next();
            if (yearInput.equalsIgnoreCase("quit")) break;

            System.out.print("Enter quarter (1 to 4): ");
            String quarterInput = scanner.next();
            if (quarterInput.equalsIgnoreCase("quit")) break;

            int year = Integer.parseInt(yearInput);
            int quarter = Integer.parseInt(quarterInput);

            if (quarter < 1 || quarter > 4) {
                System.out.println("Quarter must be between 1 and 4.\n");
                continue;
            }
            List<AppointmentReportDto> report = system.generateAppointmentsReport(year, quarter);
            String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(report);
            System.out.println("\nAppointments Report (Quarter " + quarter + ", " + year + "):");
            System.out.println(json + "\n");
        }
        System.out.println("Goodbye!");
    }
}


