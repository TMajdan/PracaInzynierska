package com.example.tomaszmajdan.pracainzynierska.Visit;

/**
 * Created by tomas on 10.12.2017.
 */

public class SendVisit {

    String doctor;
    String animal;
    String date;
    String time;
    String rodzajwizyty;
    String opis;
    String status;

    public SendVisit(){}


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public String getAnimal() {
        return animal;
    }

    public void setAnimal(String animal) {
        this.animal = animal;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getRodzajwizyty() {
        return rodzajwizyty;
    }

    public void setRodzajwizyty(String rodzjawizyty) {
        this.rodzajwizyty = rodzjawizyty;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }



}
