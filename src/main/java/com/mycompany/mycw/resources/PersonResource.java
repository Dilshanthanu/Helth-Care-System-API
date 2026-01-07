package com.mycompany.mycw.resources;

import com.mycompany.mycw.dao.PersonDAO;
import com.mycompany.mycw.models.Person;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/person")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PersonResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(PersonResource.class);
    private final PersonDAO personDAO = new PersonDAO();

    @GET
    @Path("/getpersons")
    public List<Person> getPersons() {
        try {
            return personDAO.getPersonList();
        } catch (Exception e) {
            LOGGER.error("Error occurred while fetching persons: ", e);
            throw new WebApplicationException("Internal Server Error", 500);
        }
    }

    @GET
    @Path("/{personId}")
    public List<Person> getPersonById(@PathParam("personId") int personId) {
        try {
            List<Person> newPerson = new ArrayList<>();
            Person person = personDAO.getPersonByID(personId);
            if (person != null) {
                newPerson.add(person);
            }
            return newPerson;
        } catch (Exception e) {
            LOGGER.error("Error occurred while fetching person by ID: ", e);
            throw new WebApplicationException("Internal Server Error", 500);
        }
    }

    @POST
    @Path("/addPerson")
    public String addPerson(Person person) {
        try {
            return personDAO.addPerson(person);
        } catch (Exception e) {
            LOGGER.error("Error occurred while adding person: ", e);
            throw new WebApplicationException("Internal Server Error", 500);
        }
    }

    @PUT
    @Path("/updatePerson")
    public String updatePerson(Person person) {
        try {
            return personDAO.updatePerson(person);
        } catch (Exception e) {
            LOGGER.error("Error occurred while updating person: ", e);
            throw new WebApplicationException("Internal Server Error", 500);
        }
    }

    @DELETE
    @Path("/deletePerson/{personId}")
    public String deletePerson(@PathParam("personId") int personId) {
        try {
            return personDAO.deletePerson(personId);
        } catch (Exception e) {
            LOGGER.error("Error occurred while deleting person: ", e);
            throw new WebApplicationException("Internal Server Error", 500);
        }
    }
}
