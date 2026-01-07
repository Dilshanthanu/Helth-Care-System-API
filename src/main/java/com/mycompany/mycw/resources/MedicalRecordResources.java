package com.mycompany.mycw.resources;

import com.mycompany.mycw.dao.MedicalRecordDAO;
import com.mycompany.mycw.models.MedicalRecord;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/MedicalRecord")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MedicalRecordResources {

    private static final Logger LOGGER = LoggerFactory.getLogger(MedicalRecordResources.class);
    private final MedicalRecordDAO medicalRecordDAO = new MedicalRecordDAO();

    @GET
    @Path("/getAllmedicalRecords")
    public List<MedicalRecord> getAllMedicalRecords() {
        try {
            return medicalRecordDAO.getAllMedicalRecord();
        } catch (Exception e) {
            LOGGER.error("Error occurred while getting all medical records: ", e);
            throw new WebApplicationException("Internal Server Error", 500);
        }
    }

    @GET
    @Path("/getMedicalRecordById/{medicalRecordId}")
    public MedicalRecord getMedicalReciordById(@PathParam("medicalRecordId") int medicalRecordId) {
        try {
            return medicalRecordDAO.getMedicalRecordById(medicalRecordId);
        } catch (Exception e) {
            LOGGER.error("Error occurred while getting medical record by ID: ", e);
            throw new WebApplicationException("Internal Server Error", 500);
        }
    }

    @POST
    @Path("/addMedicalRecord")
    public String addMedicalRecord(MedicalRecord medicalRecord) {
        try {
            return medicalRecordDAO.addMedicalRecord(medicalRecord);
        } catch (Exception e) {
            LOGGER.error("Error occurred while adding medical record: ", e);
            throw new WebApplicationException("Internal Server Error", 500);
        }
    }

    @PUT
    @Path("/updateMedicalRecord")
    public String updateMedicalRecord(MedicalRecord medicalRecord) {
        try {
            return medicalRecordDAO.updateMedicalRecord(medicalRecord);
        } catch (Exception e) {
            LOGGER.error("Error occurred while updating medical record: ", e);
            throw new WebApplicationException("Internal Server Error", 500);
        }
    }

    @DELETE
    @Path("/deletemedicalRecord/{medicalRecordId}")
    public String deletemedicalRecord(@PathParam("medicalRecordId") int medicalRecordId) {
        try {
            return medicalRecordDAO.deleteMedicalRecord(medicalRecordId);
        } catch (Exception e) {
            LOGGER.error("Error occurred while deleting medical record: ", e);
            throw new WebApplicationException("Internal Server Error", 500);
        }
    }
}
