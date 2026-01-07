package com.mycompany.mycw.resources;

import com.mycompany.mycw.dao.PatientDAO;
import com.mycompany.mycw.models.Patient;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/Patient")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PatientResource {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(PatientResource.class);
    private final PatientDAO patientDAO = new PatientDAO();
    
    @GET
    @Path("/getAllPatients")
    public List<Patient> getAllPatients() {
        try {
            return patientDAO.getAllPatients();
        } catch (Exception e) {
            LOGGER.error("Error occurred while getting all patients: ", e);
            throw new WebApplicationException("Internal Server Error", 500);
        }
    }
    
    @GET
    @Path("/getPatientById/{patientId}")
    public Patient getPatientById(@PathParam("patientId") int patientId) {
        try {
            return patientDAO.getPatientById(patientId);
        } catch (Exception e) {
            LOGGER.error("Error occurred while getting patient by ID: ", e);
            throw new WebApplicationException("Internal Server Error", 500);
        }
    }
    
    @POST
    @Path("/addPatient")
    public String addPatient(Patient patient) {
        try {
            return patientDAO.addPatient(patient);
        } catch (Exception e) {
            LOGGER.error("Error occurred while adding patient: ", e);
            throw new WebApplicationException("Internal Server Error", 500);
        }
    }
     
    @PUT
    @Path("/updatePatient")
    public String updatePatient(Patient patient) {
        try {
            return patientDAO.updatePatient(patient);
        } catch (Exception e) {
            LOGGER.error("Error occurred while updating patient: ", e);
            throw new WebApplicationException("Internal Server Error", 500);
        }
    }
    
    @DELETE
    @Path("/deletePatient/{patientId}")
    public String deletePatient(@PathParam("patientId") int patientId) {
        try {
            return patientDAO.deletePatient(patientId);
        } catch (Exception e) {
            LOGGER.error("Error occurred while deleting patient: ", e);
            throw new WebApplicationException("Internal Server Error", 500);
        }
    }
}
