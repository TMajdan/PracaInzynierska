package com.example.tomaszmajdan.pracainzynierska.Doctors;

import java.io.Serializable;

/**
 * Created by sumit on 12/17/2016.
 */

public class Upcomings implements Serializable{

    String name, desc, room,shopmap,phone;

        //private String title,description,image;
    public Upcomings(){}

    public Upcomings(String name, String desc, String room, String phone) {
        this.name = name;
        this.desc = desc;
        this.room = room;
        this.phone = phone;
    }


    public String getName() {
        return name;}

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
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

    public String getShopmap() {
        return shopmap;
    }

    public void setShopmap(String shopmap) {
        this.shopmap = shopmap;
    }







}