package com.mycompany.mycw.resources;

import com.mycompany.mycw.dao.BillingDAO;
import com.mycompany.mycw.models.Billing;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/Billing")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BillingResources {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(BillingResources.class);
    private final BillingDAO billingDAO = new BillingDAO();
    
    @GET
    @Path("/getAllBillings")
    public List<Billing> getAllBillings() {
        try {
            return billingDAO.getAllBilling();
        } catch (Exception e) {
            LOGGER.error("Error occurred while getting all billings: ", e);
            throw new WebApplicationException("Internal Server Error", 500);
        }
    }
    
    @GET
    @Path("/getBillById/{billId}")
    public Billing getBillById(@PathParam("billId") int billId) {
        try {
            return billingDAO.getBillingById(billId);
        } catch (Exception e) {
            LOGGER.error("Error occurred while getting billing by ID: ", e);
            throw new WebApplicationException("Internal Server Error", 500);
        }
    }
    
    @POST
    @Path("/addBill")
    public void addBill(Billing billing) {
        try {
            billingDAO.addBilling(billing);
        } catch (Exception e) {
            LOGGER.error("Error occurred while adding billing: ", e);
            throw new WebApplicationException("Internal Server Error", 500);
        }
    }
    
    @PUT
    @Path("/updateBill")
    public void updateBill(Billing billing) {
        try {
            billingDAO.updateBilling(billing);
        } catch (Exception e) {
            LOGGER.error("Error occurred while updating billing: ", e);
            throw new WebApplicationException("Internal Server Error", 500);
        }
    }
    
    @DELETE
    @Path("/deleteBill/{billId}")
    public void deleteBill(@PathParam("billId") int billId) {
        try {
            billingDAO.deleteBilling(billId);
        } catch (Exception e) {
            LOGGER.error("Error occurred while deleting billing: ", e);
            throw new WebApplicationException("Internal Server Error", 500);
        }
    }
}
