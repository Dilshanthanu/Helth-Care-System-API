package com.mycompany.mycw.resources;

import com.mycompany.mycw.dao.DoctorDAO;
import com.mycompany.mycw.models.Doctor;
import com.mycompany.mycw.models.Person;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/Doctor")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DoctorResource {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(DoctorResource.class);
    private final DoctorDAO doctorDAO = new DoctorDAO();
    
    @GET
    @Path("/getAlldoctors")
    public List<Doctor> getAlldoctors() {
        try {
            return doctorDAO.getAllDoctors();
        } catch (Exception e) {
            LOGGER.error("Error occurred while getting all doctors: ", e);
            throw new WebApplicationException("Internal Server Error", 500);
        }
    }

    @GET
    @Path("/getDoctorById/{doctorId}")
    public Person getDoctorById(@PathParam("doctorId") int doctorId) {
        try {
            return doctorDAO.getDoctorById(doctorId);
        } catch (Exception e) {
            LOGGER.error("Error occurred while getting doctor by ID: ", e);
            throw new WebApplicationException("Internal Server Error", 500);
        }
    }

    @POST
    @Path("/adddoctor")
    public String adddoctor(Doctor doctor) {
        try {
            return doctorDAO.addDoctor(doctor);
        } catch (Exception e) {
            LOGGER.error("Error occurred while adding doctor: ", e);
            throw new WebApplicationException("Internal Server Error", 500);
        }
    }

    @PUT
    @Path("/updatedoctor")
    public String updateDoctor(Doctor doctor) {
        try {
            return doctorDAO.updateDoctor(doctor);
        } catch (Exception e) {
            LOGGER.error("Error occurred while updating doctor: ", e);
            throw new WebApplicationException("Internal Server Error", 500);
        }
    }

    @DELETE
    @Path("/deleteDoctor/{doctorId}")
    public String deleteDoctor(@PathParam("doctorId") int doctorId) {
        try {
            return doctorDAO.deleteDoctor(doctorId);
        } catch (Exception e) {
            LOGGER.error("Error occurred while deleting doctor: ", e);
            throw new WebApplicationException("Internal Server Error", 500);
        }
    }
}
