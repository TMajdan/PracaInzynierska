package com.example.tomaszmajdan.pracainzynierska.ClinicDoctors;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by tomas on 17.12.2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Doc {

    String name, desc, room,phone,godz;

    String p,w,s,cz,pi,sob;

    //private String title,description,image;
    public Doc(){}

    public String getP() {
        return p;
    }

    public void setP(String p) {
        this.p = p;
    }

    public String getW() {
        return w;
    }

    public void setW(String w) {
        this.w = w;
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

    public String getCz() {
        return cz;
    }

    public void setCz(String cz) {
        this.cz = cz;
    }

    public String getPi() {
        return pi;
    }

    public void setPi(String pi) {
        this.pi = pi;
    }

    public String getSob() {
        return sob;
    }

    public void setSob(String sob) {
        this.sob = sob;
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
