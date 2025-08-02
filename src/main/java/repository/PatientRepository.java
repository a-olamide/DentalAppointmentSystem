package repository;

import model.Patient;

import java.util.List;

public interface PatientRepository {
    void addPatient(Patient patient);
    List<Patient> getPatients();
    Patient getPatient(String id);
}
