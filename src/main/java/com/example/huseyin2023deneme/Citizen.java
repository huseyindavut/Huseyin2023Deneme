package com.example.huseyin2023deneme;

public class Citizen {

    private int id;
    private String firstName;
    private String surname;
    private String birthDay;
    private String socialNumber;
    private String phone;
    private String email;
    private String city;
    private String street;

    public Citizen(int id, String firstName, String surname, String birthDay, String socialNumber, String phone, String email, String city, String street) {
        this.id = id;
        this.firstName = firstName;
        this.surname = surname;
        this.birthDay = birthDay;
        this.socialNumber = socialNumber;
        this.phone = phone;
        this.email = email;
        this.city = city;
        this.street = street;
    }

    public Citizen() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getSocialNumber() {
        return socialNumber;
    }

    public void setSocialNumber(String socialNumber) {
        this.socialNumber = socialNumber;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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
