package com.example.tomaszmajdan.pracainzynierska;

/**
 * Created by tomas on 26.11.2017.
 */

public class UserData {



    String name, surname, phone, city, adres;

    //private String title,description,image;
    public UserData(){}

    public UserData(String name, String surname, String phone, String city, String adres)  {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.city = city;
        this.adres = adres;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }


}
