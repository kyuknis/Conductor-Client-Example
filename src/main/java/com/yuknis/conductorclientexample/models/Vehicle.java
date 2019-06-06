package com.yuknis.conductorclientexample.models;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Vehicle {

    @NotNull
    @Size(min = 1)
    public String make;

    @NotNull
    @Size(min = 1)
    public String model;

    public String trim;

    @NotNull
    @Size(min = 1)
    public short year;

    public Vehicle() {
        // ...
    }

    public Vehicle(String make, String model, String trim, short year) {
        this.make = make;
        this.model = model;
        this.trim = trim;
        this.year = year;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getTrim() {
        return trim;
    }

    public void setTrim(String trim) {
        this.trim = trim;
    }

    public short getYear() {
        return year;
    }

    public void setYear(short year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", trim='" + trim + '\'' +
                ", year=" + year +
                '}';
    }
}
