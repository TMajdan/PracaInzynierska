package com.example.tomaszmajdan.pracainzynierska;

/**
 * Created by Tomasz Majdan on 14.10.2017.
 */

import com.google.firebase.database.IgnoreExtraProperties;


@IgnoreExtraProperties
public class User {

    public String name;
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