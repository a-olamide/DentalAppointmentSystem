package dto;

import java.time.LocalDate;
import java.time.LocalTime;

public record AppointmentReportDto (
        String appointmentId,
        String appointmentDate,
        String appointmentTime,
        String patientFirstName,
        String patientLastName,
        String patientPhoneNumber,
        String DateOfBirth
) {

}
