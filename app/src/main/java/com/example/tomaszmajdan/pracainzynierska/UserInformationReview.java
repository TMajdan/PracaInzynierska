package com.example.tomaszmajdan.pracainzynierska;

/**
 * Created by Tomasz Majdan on 05.09.2017.
 */

public class UserInformationReview {

    protected String name;
    protected String surname;
    private String pesel;
    private String address;
    private String city;
    private String phone;
    private String zip;

    public UserInformationReview(String name, String surname ){
        this.name=name;
        this.surname=surname;
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

    public void setPesel(String pesel) {this.pesel= pesel;}

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {this.address= address;}

    public String getCity() {
        return city;
    }

    public void setCity(String city) {this.city= city;}

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {this.phone= phone;}

    public String getZip() {return zip;}

    public void setZip(String zip) {this.zip= zip;}

}
