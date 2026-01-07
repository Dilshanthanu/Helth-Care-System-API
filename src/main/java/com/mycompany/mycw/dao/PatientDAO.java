package com.mycompany.mycw.dao;

import com.mycompany.mycw.models.Patient;
import com.mycompany.mycw.models.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PatientDAO {

    private static final Logger logger = LoggerFactory.getLogger(PatientDAO.class);
    public static final Map<Integer, Patient> patients = new HashMap<>();

    static {
        Patient patient = new Patient(4, "sdfdsdf", "faefewf", 4, "eqfgrg", "gssrfr", "fsvfr", "sfVFS");
        patients.put(patient.getPatient_Id(), patient);
    }

    public List<Patient> getAllPatients() {
        try {
            if (patients.isEmpty()) {
                return null;
            } else {
                return new ArrayList<>(patients.values());
            }
        } catch (Exception e) {
            logger.error("Error retrieving all patients: {}", e.getMessage());
            throw e;
        }
    }

    public Patient getPatientById(int id) {
        try {
            if (patients.containsKey(id)) {
                return patients.get(id);
            } else {
                return null;
            }
        } catch (Exception e) {
            logger.error("Error retrieving patient by ID: {}", e.getMessage());
            throw e;
        }
    }

    public String addPatient(Patient patient) {
        try {
            patients.put(patient.getPatient_Id(), patient);
            Person person = new Person(patient.getPerson_Id(),
                    patient.getName(), patient.getAddress(),
                    patient.getContact_number(), patient.getE_mail());
            PersonDAO.addPerson(person);
            return "Patient added successfully";
        } catch (Exception e) {
            logger.error("Error adding patient: {}", e.getMessage());
            throw e;
        }
    }

    public String updatePatient(Patient patient) {
        try {
            if (patients.containsKey(patient.getPatient_Id())) {
                patients.put(patient.getPatient_Id(), patient);
                Person person = new Person(
                        patient.getPerson_Id(),
                        patient.getName(),
                        patient.getAddress(),
                        patient.getContact_number(),
                        patient.getE_mail());
                PersonDAO.updatePerson(person);
                return "Patient updated successfully";
            } else {
                return "Cannot find the patient";
            }
        } catch (Exception e) {
            logger.error("Error updating patient: {}", e.getMessage());
            throw e;
        }
    }

    public String deletePatient(int id) {
        try {
            if (patients.containsKey(id)) {
                patients.remove(id);
                return "Patient deleted successfully";
            } else {
                return "Cannot find the patient";
            }
        } catch (Exception e) {
            logger.error("Error deleting patient: {}", e.getMessage());
            throw e;
        }
    }
}
