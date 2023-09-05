package com.microservice.driver.model;

import java.util.Date;

public class Driver {
    private int id;
    private String lastName;
    private String firstName;
    private Date birthDate;
    private String licenseid;
    private String licenseissueDate;

    public Driver(int id, String lastName, String firstName, Date birthDate, String licenseid, String licenseissueDate) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.birthDate = birthDate;
        this.licenseid = licenseid;
        this.licenseissueDate = licenseissueDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getLicenseid() {
        return licenseid;
    }

    public void setLicenseid(String licenseid) {
        this.licenseid = licenseid;
    }

    public String getLicenseissueDate() {
        return licenseissueDate;
    }

    public void setLicenseissueDate(String licenseissueDate) {
        this.licenseissueDate = licenseissueDate;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", birthDate=" + birthDate +
                ", licenseid='" + licenseid + '\'' +
                ", licenseissueDate='" + licenseissueDate + '\'' +
                '}';
    }
}
