package com.example.tomaszmajdan.pracainzynierska.Visit;

import com.example.tomaszmajdan.pracainzynierska.MainActivity;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by tomas on 25.11.2017.
 */

public class
Visits {

    private String doctor;
    private String time;
    private String date;
    private String animal;
    private String opis;
    private String status;
    private String room;
    private String rodzajwizyty;
    private String zalecenia;
    private String recepty;
    private String key;


    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }



    public String getZalecenia() {
        return zalecenia;
    }

    public void setZalecenia(String zalecenia) {
        this.zalecenia = zalecenia;
    }

    public String getRecepty() {
        return recepty;
    }

    public void setRecepty(String recepty) {
        this.recepty = recepty;
    }


    @JsonProperty("room")
    public String getroom() {
        return room;
    }

    public void setroom(String room) {
        this.room = room;
    }
    @JsonProperty("doctor")
    public String getdoctor() {
        return doctor;
    }

    public void setdoctor(String doctor) {
        this.doctor = doctor;
    }
    @JsonProperty("time")
    public String gettime() {
        return time;
    }

    public void settime(String time) {
        this.time = time;
    }
    @JsonProperty("date")
    public String getdate() {
        return date;
    }

    public void setdate(String date) {
        this.date = date;
    }
    @JsonProperty("animal")
    public String getanimal() {
        return animal;
    }

    public void setanimal(String animal) {
        this.animal = animal;
    }
    @JsonProperty("opis")
        public String getopis() {
        return opis;
    }

    public void setopis(String opis) {
        this.opis = opis;
    }
    @JsonProperty("status")
    public String getstatus() {
        return status;
    }

    public void setstatus(String status) {
        this.status = status;
    }
    @JsonProperty("rodzajwizyty")
    public String getrodzajwizyty() {
        return rodzajwizyty;
    }

    public void setrodzajwizyty(String rodzajwizyty) {
        this.rodzajwizyty = rodzajwizyty;
    }




    //private String title,description,image;
    public Visits(){}






}
