package com.mycompany.mycw.dao;

import com.mycompany.mycw.models.Appointment;
import com.mycompany.mycw.models.Doctor;
import com.mycompany.mycw.models.Patient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AppointmentDAO {

    private static final Logger logger = LoggerFactory.getLogger(AppointmentDAO.class);
    private static final Map<Integer, Appointment> appointments = new HashMap<>();
    
    static {
        
         Patient patient = new Patient(4, "sdfdsdf", "faefewf", 4, "eqfgrg", "gssrfr", "fsvfr", "sfVFS");

        // Create sample Doctor
        Doctor doctor = new Doctor(1, "a", 1, "f", "d", "122", "sdc");

        // Create sample Billing
        Appointment appointment = new Appointment(1, new Date(), "10:00 AM", patient, doctor);
        appointments.put(1, appointment);
    }

    public List<Appointment> getAllAppointment() {
        try {
            return new ArrayList<>(appointments.values());
        } catch (Exception e) {
            logger.error("Error retrieving all appointments: {}", e.getMessage());
            throw e;
        }
    }

    public Appointment getAppointmentById(int Id) {
        try {
            return appointments.get(Id);
        } catch (Exception e) {
            logger.error("Error retrieving appointment by ID: {}", e.getMessage());
            throw e;
        }
    }

    public String addAppointment(Appointment appointment) {
        try {
            if(DoctorDAO.doctors.containsKey(appointment.getDoctor().getDoctor_Id())&& 
                    PatientDAO.patients.containsKey(appointment.getPatient().getPatient_Id())){
                appointments.put(appointment.getappointment_Id(), appointment);
                return "Appointment Added";
            }else{
                return "Cannot find doctor or patient";
            }
            
        } catch (Exception e) {
            logger.error("Error adding appointment: {}", e.getMessage());
            throw e;
        }
    }

    public String updateAppointment(Appointment appointment) {
        try {
            if (appointments.containsKey(appointment.getappointment_Id())){
                appointments.put(appointment.getappointment_Id(), appointment);
                return "Appointment Updated";
            }else{
                return "Cannot find an appointment";
            }
            
        } catch (Exception e) {
            logger.error("Error updating appointment: {}", e.getMessage());
            throw e;
        }
    }

    public String deleteAppointment(int id) {
        try {
           if (appointments.containsKey(id)){
                appointments.remove(id);
                return "Appointment Deleted";
            }else{
                return "Cannot find an appointment";
            }
        } catch (Exception e) {
            logger.error("Error deleting appointment: {}", e.getMessage());
            throw e;
        }
    }
}
