package com.mycompany.mycw.dao;

import com.mycompany.mycw.models.Doctor;
import com.mycompany.mycw.models.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DoctorDAO {

    private static final Logger logger = LoggerFactory.getLogger(DoctorDAO.class);
    public static final Map<Integer, Doctor> doctors = new HashMap<>();

    static {
        Doctor doctor = new Doctor(1, "a", 1, "f", "d", "122", "sdc");
        doctors.put(doctor.getDoctor_Id(), doctor);
    }

    public List<Doctor> getAllDoctors() {
        try {
            return new ArrayList<>(doctors.values());
        } catch (Exception e) {
            logger.error("Error retrieving all doctors: {}", e.getMessage());
            throw e;
        }
    }

    public Doctor getDoctorById(int Id) {
        try {
            if (doctors.containsKey(Id)) {
                return doctors.get(Id);
            } else {
                return null;
            }
        } catch (Exception e) {
            logger.error("Error retrieving doctor by ID: {}", e.getMessage());
            throw e;
        }
    }

    public String addDoctor(Doctor doctor) {
        try {
            doctors.put(doctor.getDoctor_Id(), doctor);
            Person person = new Person(
                    doctor.getPerson_Id(),
                    doctor.getName(),
                    doctor.getAddress(),
                    doctor.getContact_number(),
                    doctor.getE_mail());
            PersonDAO.addPerson(person);
            return "Doctor added successfully";
        } catch (Exception e) {
            logger.error("Error adding doctor: {}", e.getMessage());
            throw e;
        }
    }

    public String updateDoctor(Doctor doctor) {
        try {
            if (doctors.containsKey(doctor.getDoctor_Id())) {
                doctors.put(doctor.getDoctor_Id(), doctor);
                Person person = new Person(
                        doctor.getPerson_Id(),
                        doctor.getName(),
                        doctor.getAddress(),
                        doctor.getContact_number(),
                        doctor.getE_mail());
                PersonDAO.updatePerson(person);
                return "Doctor updated successfully";
            } else {
                return "Cannot find the doctor";
            }
        } catch (Exception e) {
            logger.error("Error updating doctor: {}", e.getMessage());
            throw e;
        }
    }

    public String deleteDoctor(int Id) {
        try {
            if (doctors.containsKey(Id)) {
                doctors.remove(Id);
                PersonDAO.deletePerson(Id);
                return "Doctor deleted successfully";
            } else {
                return "Cannot find the doctor";
            }
        } catch (Exception e) {
            logger.error("Error deleting doctor: {}", e.getMessage());
            throw e;
        }
    }
}
