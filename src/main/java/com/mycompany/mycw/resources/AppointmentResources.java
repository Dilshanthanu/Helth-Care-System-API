package com.mycompany.mycw.resources;

import com.mycompany.mycw.dao.AppointmentDAO;
import com.mycompany.mycw.models.Appointment;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Path("/Appointment")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AppointmentResources {

    private static final Logger LOGGER = Logger.getLogger(AppointmentResources.class.getName());
    private final AppointmentDAO appointmentDAO = new AppointmentDAO();

    @GET
    @Path("/getAllappointments")
    public List<Appointment> getAllappointments() {
        try {
            return appointmentDAO.getAllAppointment();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error occurred while getting all appointments: ", e);
            throw new WebApplicationException("Internal Server Error", Response.Status.INTERNAL_SERVER_ERROR);
        }
    }

    @GET
    @Path("/getAppointmentById/{appointmentId}")
    public Appointment getAppointmentById(@PathParam("appointmentId") int appointmentId) {
        try {
            return appointmentDAO.getAppointmentById(appointmentId);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error occurred while getting appointment by ID: ", e);
            throw new WebApplicationException("Internal Server Error", Response.Status.INTERNAL_SERVER_ERROR);
        }
    }

    @POST
    @Path("/addAppointment")
    public Response addAppointment(Appointment appointment) {
        try {
            appointmentDAO.addAppointment(appointment);
            return Response.status(Response.Status.CREATED).build();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error occurred while adding appointment: ", e);
            throw new WebApplicationException("Internal Server Error", Response.Status.INTERNAL_SERVER_ERROR);
        }
    }

    @PUT
    @Path("/updateAppointment")
    public Response updateAppointment(Appointment appointment) {
        try {
            appointmentDAO.updateAppointment(appointment);
            return Response.status(Response.Status.OK).build();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error occurred while updating appointment: ", e);
            throw new WebApplicationException("Internal Server Error", Response.Status.INTERNAL_SERVER_ERROR);
        }
    }

    @DELETE
    @Path("/deleteAppointment/{appointmentId}")
    public Response deleteAppointment(@PathParam("appointmentId") int appointmentId) {
        try {
            appointmentDAO.deleteAppointment(appointmentId);
            return Response.status(Response.Status.NO_CONTENT).build();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error occurred while deleting appointment: ", e);
            throw new WebApplicationException("Internal Server Error", Response.Status.INTERNAL_SERVER_ERROR);
        }
    }
}
