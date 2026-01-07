package com.mycompany.mycw.dao;

import com.mycompany.mycw.models.Doctor;
import com.mycompany.mycw.models.Patient;
import com.mycompany.mycw.models.Prescription;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PrescriptionDAO {

    private static final Logger LOGGER = Logger.getLogger(PrescriptionDAO.class.getName());

    private static Map<Integer, Prescription> prescriptions = new HashMap<>();
    
    static{
        Patient patient = new Patient(4, "sdfdsdf", "faefewf", 4, "eqfgrg", "gssrfr", "fsvfr", "sfVFS");

        // Create sample Doctor
        Doctor doctor = new Doctor(1, "a", 1, "f", "d", "122", "sdc");

        // Create sample Prescription
        Prescription prescription = new Prescription(1, patient, doctor, "Aspirin", "1 tablet", "Take with water", "10 days");
        
        prescriptions.put(1, prescription);
}

    public List<Prescription> getAllPrescription() {
        try {
            if (prescriptions.isEmpty()) {
                return null;
            } else {
                return new ArrayList<>(prescriptions.values());
            }
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error occurred while getting all prescriptions: ", e);
            throw new RuntimeException("Error occurred while getting all prescriptions", e);
        }
    }

    public Prescription getPrescriptionById(int Id) {
        try {
            if (prescriptions.containsKey(Id)) {
                return prescriptions.get(Id);
            } else {
                return null;
            }
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error occurred while getting prescription by ID: ", e);
            throw new RuntimeException("Error occurred while getting prescription by ID", e);
        }
    }

    public String addPrescription(Prescription prescription) {
        try {
            prescriptions.put(prescription.getPrescription_Id(), prescription);
            return "Prescription added";
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error occurred while adding prescription: ", e);
            throw new RuntimeException("Error occurred while adding prescription", e);
        }
    }

    public String updatePrescription(Prescription prescription) {
        try {
            if (prescriptions.containsKey(prescription.getPrescription_Id())) {
                prescriptions.put(prescription.getPrescription_Id(), prescription);
                return "Prescription Updated";
            } else {
                return "Cannot find the prescription";
            }
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error occurred while updating prescription: ", e);
            throw new RuntimeException("Error occurred while updating prescription", e);
        }
    }

    public String deletePrescription(int Id) {
        try {
            if (prescriptions.containsKey(Id)) {
                prescriptions.remove(Id);
                return "Prescription Deleted";
            } else {
                return "Cannot find the prescription";
            }
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error occurred while deleting prescription: ", e);
            throw new RuntimeException("Error occurred while deleting prescription", e);
        }
    }
}
