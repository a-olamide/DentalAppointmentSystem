package repository.impl;

import model.Patient;
import repository.PatientRepository;

import java.util.ArrayList;
import java.util.List;

public class PatientRepositoryImpl implements PatientRepository {
    private static PatientRepositoryImpl instance;
    private final List<Patient> patients = new ArrayList<Patient>();
    private PatientRepositoryImpl() {}
    public static PatientRepositoryImpl getInstance() {
        if (instance == null || !instance.patients.isEmpty()) {
            instance = new PatientRepositoryImpl();
        }
        return instance;
    }
    @Override
    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    @Override
    public List<Patient> getPatients() {
        return patients;
    }

    @Override
    public Patient getPatient(String id) {
        return patients.stream().filter(patient -> patient.getId().equals(id)).findFirst().orElse(null);
    }
}
