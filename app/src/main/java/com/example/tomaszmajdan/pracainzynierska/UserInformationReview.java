package com.example.tomaszmajdan.pracainzynierska;

/**
 * Created by Tomasz Majdan on 05.09.2017.
 */

public class UserInformationReview {

    private String name;
    private String surname;
    private String pesel;
    private String address;
    private String city;
    private String phone;
    private String zip;

    public UserInformationReview(){

    }
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
        this.pesel= pesel;
    }

}
