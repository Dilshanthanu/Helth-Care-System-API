package com.mycompany.mycw.dao;

import com.mycompany.mycw.models.Billing;
import com.mycompany.mycw.models.Doctor;
import com.mycompany.mycw.models.Patient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BillingDAO {

    private static final Logger logger = LoggerFactory.getLogger(BillingDAO.class);
    private static Map<Integer, Billing> billings = new HashMap<>();
    
    static {
        
         Patient patient = new Patient(4, "sdfdsdf", "faefewf", 4, "eqfgrg", "gssrfr", "fsvfr", "sfVFS");

        // Create sample Doctor
        Doctor doctor = new Doctor(1, "a", 1, "f", "d", "122", "sdc");

        // Create sample Billing
        Billing billing = new Billing(1, patient, doctor, 150.50, true);
        billings.put(1, billing);
    }

    public List<Billing> getAllBilling() {
        try {
            if (billings.isEmpty()) {
                return null;
            } else {
                return new ArrayList<>(billings.values());
            }
        } catch (Exception e) {
            logger.error("Error retrieving all billings: {}", e.getMessage());
            throw e;
        }
    }

    public Billing getBillingById(int Id) {
        try {
            if (billings.containsKey(Id)) {
                return billings.get(Id);
            } else {
                return null;
            }
        } catch (Exception e) {
            logger.error("Error retrieving billing by ID: {}", e.getMessage());
            throw e;
        }
    }

    public String addBilling(Billing billing) {
        try {
            billings.put(billing.getbilling_Id(), billing);
            return "Bill added successfully";
        } catch (Exception e) {
            logger.error("Error adding billing: {}", e.getMessage());
            throw e;
        }
    }

    public String updateBilling(Billing billing) {
        try {
            if (billings.containsKey(billing.getbilling_Id())) {
                billings.put(billing.getbilling_Id(), billing);
                return "Bill updated successfully";
            } else {
                return "Cannot find the Bill";
            }
        } catch (Exception e) {
            logger.error("Error updating billing: {}", e.getMessage());
            throw e;
        }
    }

    public String deleteBilling(int Id) {
        try {
            if (billings.containsKey(Id)) {
                billings.remove(Id);
                return "Bill deleted successfully";
            } else {
                return "Cannot find the Bill";
            }
        } catch (Exception e) {
            logger.error("Error deleting billing: {}", e.getMessage());
            throw e;
        }
    }
}
