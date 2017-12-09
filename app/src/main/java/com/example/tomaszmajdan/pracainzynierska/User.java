package com.example.tomaszmajdan.pracainzynierska;

/**
 * Created by Tomasz Majdan on 14.10.2017.
 */

import com.google.firebase.database.IgnoreExtraProperties;


@IgnoreExtraProperties
public class User {

    public String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String surname;
    public String pesel;
    public String phone;
    public String address;
    public String city;
    public String zip;

    // Default constructor required for calls to
    // DataSnapshot.getValue(User.class)
    public User() {
    }

    public User(String name, String surname, String pesel, String phone, String address, String city, String zip) {
        this.name = name;
        this.surname = surname;
        this.pesel = pesel;
        this.phone = phone;
        this.address = address;
        this.city = city;
        this.zip = zip;

    }
}