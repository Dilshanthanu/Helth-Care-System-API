package com.mycompany.mycw.dao;

import com.mycompany.mycw.models.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PersonDAO {

    private static final Logger logger = LoggerFactory.getLogger(PersonDAO.class);
    private static final Map<Integer, Person> Persons = new HashMap<>();

    static {
        Person person = new Person(1, "a", "c", "f", "e");
        Persons.put(person.getPerson_Id(), person);
    }

    public static List<Person> getPersonList() {
        return new ArrayList<>(Persons.values());
    }

    public static Person getPersonByID(int id) {
        try {
            if (Persons.containsKey(id)) {
                return Persons.get(id);
            } else {
                throw new IllegalArgumentException("Person with ID " + id + " does not exist.");
            }
        } catch (IllegalArgumentException e) {
            logger.error("Error retrieving person by ID: {}", e.getMessage());
            throw e;
        }
    }

    public static String addPerson(Person person) {
        try {
            Persons.put(person.getPerson_Id(), person);
            return "New Person added";
        } catch (Exception e) {
            logger.error("Error adding person: {}", e.getMessage());
            throw e;
        }
    }

    public static String updatePerson(Person updatedPerson) {
        try {
            if (Persons.containsKey(updatedPerson.getPerson_Id())) {
                Persons.put(updatedPerson.getPerson_Id(), updatedPerson);
                return "Person updated successfully";
            } else {
                throw new IllegalArgumentException("Cannot find the person with ID " + updatedPerson.getPerson_Id());
            }
        } catch (IllegalArgumentException e) {
            logger.error("Error updating person: {}", e.getMessage());
            throw e;
        }
    }

    public static String deletePerson(int ID) {
        try {
            if (Persons.containsKey(ID)) {
                Persons.remove(ID);
                return "Person has been deleted successfully";
            } else {
                throw new IllegalArgumentException("Cannot find the person with ID " + ID);
            }
        } catch (IllegalArgumentException e) {
            logger.error("Error deleting person: {}", e.getMessage());
            throw e;
        }
    }
}
