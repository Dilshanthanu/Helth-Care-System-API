package com.mycompany.mycw.dao;

import com.mycompany.mycw.models.MedicalRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MedicalRecordDAO {

    private static final Logger logger = LoggerFactory.getLogger(MedicalRecordDAO.class);
    private static final Map<Integer, MedicalRecord> medicalRecords = new HashMap<>();
    private static final PatientDAO patientDAO = new PatientDAO();

//    static {
//        MedicalRecord medicalRecord = new MedicalRecord(1, patientDAO.getPatientById(4), "kknjb", "vgvghc");
//        medicalRecords.put(medicalRecord.getMedicalRecord_Id(), medicalRecord);
//    }

    public List<MedicalRecord> getAllMedicalRecord() {
        try {
            if (medicalRecords.isEmpty()) {
                return null;
            } else {
                return new ArrayList<>(medicalRecords.values());
            }
        } catch (Exception e) {
            logger.error("Error retrieving all medical records: {}", e.getMessage());
            throw e;
        }
    }

    public MedicalRecord getMedicalRecordById(int Id) {
        try {
            if (medicalRecords.containsKey(Id)) {
                return medicalRecords.get(Id);
            } else {
                return null;
            }
        } catch (Exception e) {
            logger.error("Error retrieving medical record by ID: {}", e.getMessage());
            throw e;
        }
    }

    public String addMedicalRecord(MedicalRecord medicalRecord) {
        try {
            medicalRecords.put(medicalRecord.getMedicalRecord_Id(), medicalRecord);
            return "Medical Record Added";
        } catch (Exception e) {
            logger.error("Error adding medical record: {}", e.getMessage());
            throw e;
        }
    }

    public String updateMedicalRecord(MedicalRecord medicalRecord) {
        try {
            if (medicalRecords.containsKey(medicalRecord.getMedicalRecord_Id())) {
                medicalRecords.put(medicalRecord.getMedicalRecord_Id(), medicalRecord);
                return "Medical Record Updated";
            } else {
                return "Cannot find the Medical Record";
            }
        } catch (Exception e) {
            logger.error("Error updating medical record: {}", e.getMessage());
            throw e;
        }
    }

    public String deleteMedicalRecord(int Id) {
        try {
            if (medicalRecords.containsKey(Id)) {
                medicalRecords.remove(Id);
                return "Medical record Deleted";
            } else {
                return "Cannot find the medical Record";
            }
        } catch (Exception e) {
            logger.error("Error deleting medical record: {}", e.getMessage());
            throw e;
        }
    }
}
