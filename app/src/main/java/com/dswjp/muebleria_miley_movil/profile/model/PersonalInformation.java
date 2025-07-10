package com.dswjp.muebleria_miley_movil.profile.model;

import com.dswjp.muebleria_miley_movil.security.model.User;

import java.time.LocalDate;

import lombok.*;

public class PersonalInformation {
    private String id;
    private String firstName;
    private String lastName;
    private String phone;
    private String photoUrl;
    private LocalDate birthdate;
    private User user;
    private Address address;

    public PersonalInformation() {
    }

    public PersonalInformation(Address address, LocalDate birthdate, String firstName, String id, String lastName, String phone, String photoUrl, User user) {
        this.address = address;
        this.birthdate = birthdate;
        this.firstName = firstName;
        this.id = id;
        this.lastName = lastName;
        this.phone = phone;
        this.photoUrl = photoUrl;
        this.user = user;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getFullName() {
        return this.firstName + " " + this.getLastName();
    }
}
