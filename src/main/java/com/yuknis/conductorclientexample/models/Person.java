package com.yuknis.conductorclientexample.models;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Map;

@Valid
public class Person {

    @NotNull
    @Size(min = 1)
    protected String firstName;

    @NotNull
    @Size(min = 1)
    protected String lastName;

    @Valid
    protected List<Vehicle> vehicles;

    /**
     * Empty constructor
     */
    public Person() {
        // ...
    }

    /**
     * Fully initialized object
     *
     * @param firstName
     * @param lastName
     * @param vehicles
     */
    public Person(String firstName, String lastName, List<Vehicle> vehicles) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setVehicles(vehicles);
    }

    /**
     * Gets the person's first name
     *
     * @return
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the person's first name
     *
     * @return
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the person's last name
     *
     * @return
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the person's first name
     *
     * @return
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the person's vehicles
     *
     * @return
     */
    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    /**
     * Sets the person's vehicles
     *
     * @param vehicles
     */
    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", vehicles=" + vehicles +
                '}';
    }

    public static class PersonFactory {

        protected ObjectMapper objectMapper = new ObjectMapper();

        /**
         * Empty constructor
         *
         */
        public PersonFactory() {
            // ...
        }

        /**
         * Creates a new Person instance from a map
         *
         * @param map
         * @return
         */
        public Person create(Map<String, Object> map) {

            Person person = objectMapper.convertValue(map, Person.class);

            return person;

        }

    }

}
