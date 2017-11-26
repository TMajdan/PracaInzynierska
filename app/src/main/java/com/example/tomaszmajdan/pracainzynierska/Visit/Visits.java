package com.example.tomaszmajdan.pracainzynierska.Visit;

/**
 * Created by tomas on 25.11.2017.
 */

public class Visits {

    String name, desc, room,shopmap,phone,godz,date, animal, opis,status, rodzaj;

    //private String title,description,image;
    public Visits(){}

    public Visits(String name, String room, String godz, String date, String animal, String opis, String status, String rodzaj) {
        this.name = name;
        this.room = room;
        this.godz = godz;
        this.date = date;
        this.animal = animal;
        this.opis = opis;
        this.status = status;
        this.rodzaj = rodzaj;
    }


    public String getName() {
        return name;}

    public void setName(String name) {
        this.name = name;
    }


    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGodz() {
        return godz;
    }

    public void setGodz(String godz) {
        this.godz = godz;
    }

    public String getDate() {
        return date;
    }

    public void setRodzaj(String rodzaj) {
        this.rodzaj = rodzaj;
    }

    public String getRodzaj() {
        return rodzaj;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAnimal() {
        return animal;
    }

    public void setAnimal (String animal) {
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
}
