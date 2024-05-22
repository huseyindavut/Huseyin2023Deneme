package com.example.huseyin2023deneme;

public class Citizen {

    private Integer CID;
    private String firstName;
    private String surname;
    private String doB;
    private String SSN;
    private String phoneNr;
    private String email, city, street;

    public Citizen(Integer CID, String firstName, String surname, String doB, String SSN, String phoneNr, String email, String city, String street) {
        this.CID = CID;
        this.firstName = firstName;
        this.surname = surname;
        this.doB = doB;
        this.SSN = SSN;
        this.phoneNr = phoneNr;
        this.email = email;
        this.city = city;
        this.street = street;
    }

    public Citizen() {}


    public Integer getCID() {
        return CID;
    }

    public void setCID(Integer CID) {
        this.CID = CID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDoB() {
        return doB;
    }

    public void setDoB(String doB) {
        this.doB = doB;
    }

    public String getSSN() {
        return SSN;
    }

    public void setSSN(String SSN) {
        this.SSN = SSN;
    }

    public String getPhoneNr() {
        return phoneNr;
    }

    public void setPhoneNr(String phoneNr) {
        this.phoneNr = phoneNr;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}
