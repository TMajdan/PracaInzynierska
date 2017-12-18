package com.example.tomaszmajdan.pracainzynierska.ClinicDoctors;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by tomas on 17.12.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Doc {

    String name, desc, room,phone,godz;

    String drWorkMonday,drWorkTuesday,drWorkWednesday,drWorkThursday,drWorkFriday,drWorkSaturday;

    //private String title,description,image;
    public Doc(){}

    public String getdrWorkMonday() {
        return drWorkMonday;
    }

    public void setdrWorkMonday(String drWorkMonday) {
        this.drWorkMonday = drWorkMonday;
    }

    public String getdrWorkTuesday() {
        return drWorkTuesday;
    }

    public void setdrWorkTuesday(String drWorkTuesday) {
        this.drWorkTuesday = drWorkTuesday;
    }

    public String getdrWorkWednesday() {
        return drWorkWednesday;
    }

    public void setdrWorkWednesday(String drWorkWednesday) {
        this.drWorkWednesday = drWorkWednesday;
    }

    public String getdrWorkThursday() {
        return drWorkThursday;
    }

    public void setdrWorkThursday(String drWorkThursday) {
        this.drWorkThursday = drWorkThursday;
    }

    public String getdrWorkFriday() {
        return drWorkFriday;
    }

    public void setdrWorkFriday(String drWorkFriday) {
        this.drWorkFriday = drWorkFriday;
    }

    public String getdrWorkSaturday() {
        return drWorkSaturday;
    }

    public void setdrWorkSaturday(String drWorkSaturday) {
        this.drWorkSaturday = drWorkSaturday;
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

    public String getGodz() {
        return godz;
    }

    public void setGodz(String godz) {
        this.godz = godz;
    }



}
