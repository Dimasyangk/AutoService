package com.example.autoservice.mvvm.model;

import java.util.Date;

public class User {
    private int id;
    private String name, city, tel;
    private Date date;

    public User(int id, String name, String city, String tel) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.tel = tel;

        this.date = new Date();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
