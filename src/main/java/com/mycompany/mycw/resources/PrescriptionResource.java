package com.mycompany.mycw.resources;

import com.mycompany.mycw.dao.PrescriptionDAO;
import com.mycompany.mycw.models.Prescription;
import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/Prescription")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PrescriptionResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(PrescriptionResource.class);
    private final PrescriptionDAO prescriptionDAO = new PrescriptionDAO();

    @GET
    @Path("/getAllPrescriptions")
    public List<Prescription> getAllPrescriptions() {
        try {
            return prescriptionDAO.getAllPrescription();
        } catch (Exception e) {
            LOGGER.error("Error occurred while getting all prescriptions: ", e);
            throw new WebApplicationException("Internal Server Error", 500);
        }
    }

    @GET
    @Path("/getPrescriptionById/{PrescriptionId}")
    public Prescription getPrescriptionById(@PathParam("PrescriptionId") int PrescriptionId) {
        try {
            return prescriptionDAO.getPrescriptionById(PrescriptionId);
        } catch (Exception e) {
            LOGGER.error("Error occurred while getting prescription by ID: ", e);
            throw new WebApplicationException("Internal Server Error", 500);
        }
    }

    @POST
    @Path("/addPrescription")
    public void addPrescription(Prescription prescription) {
        try {
            prescriptionDAO.addPrescription(prescription);
        } catch (Exception e) {
            LOGGER.error("Error occurred while adding prescription: ", e);
            throw new WebApplicationException("Internal Server Error", 500);
        }
    }

    @PUT
    @Path("/updatePrescription")
    public void updatePrescription(Prescription prescription) {
        try {
            prescriptionDAO.updatePrescription(prescription);
        } catch (Exception e) {
            LOGGER.error("Error occurred while updating prescription: ", e);
            throw new WebApplicationException("Internal Server Error", 500);
        }
    }

    @DELETE
    @Path("/deletePrescription/{PrescriptionId}")
    public void deletePrescription(@PathParam("PrescriptionId") int PrescriptionId) {
        try {
            prescriptionDAO.deletePrescription(PrescriptionId);
        } catch (Exception e) {
            LOGGER.error("Error occurred while deleting prescription: ", e);
            throw new WebApplicationException("Internal Server Error", 500);
        }
    }
}
