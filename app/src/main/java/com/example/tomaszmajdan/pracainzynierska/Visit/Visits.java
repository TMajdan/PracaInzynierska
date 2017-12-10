package com.example.tomaszmajdan.pracainzynierska.Visit;

import com.example.tomaszmajdan.pracainzynierska.MainActivity;

/**
 * Created by tomas on 25.11.2017.
 */

public class
Visits {

    String doctor;
    String time;
    String date;
    String animal;
    String opis;
    String status;

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAnimal() {
        return animal;
    }

    public void setAnimal(String animal) {
        this.animal = animal;
    }

        public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRodzajwizyty() {
        return rodzajwizyty;
    }

    public void setRodzajwizyty(String rodzajwizyty) {
        this.rodzajwizyty = rodzajwizyty;
    }

    String rodzajwizyty;

    //private String title,description,image;
    public Visits(){}

    public Visits(String doctor, String time, String date, String animal, String opis, String status, String rodzajwizyty) {
        this.doctor = doctor;
        this.time = time;
        this.date = date;
        this.animal = animal;
        this.opis = opis;
        this.status = status;
        this.rodzajwizyty = rodzajwizyty;
    }




}
