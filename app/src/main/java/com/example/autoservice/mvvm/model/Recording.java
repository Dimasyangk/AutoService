package com.example.autoservice.mvvm.model;

import java.util.Date;

public class Recording {
    private int id;
    private String city, name, telephoneNumber;
    private String reason;
    private Date date;
    private Car car;

    private String whatWereDone, comment;
    private int price;

    public Recording(int id, String city, String name, String telephoneNumber, String reason, Car car) {
        this.id = id;
        this.city = city;
        this.name = name;
        this.telephoneNumber = telephoneNumber;
        this.reason = reason;
        this.car = car;

        this.date = new Date();
        this.whatWereDone = "Пока работа не была проделана";
        this.comment = "Комментарий отсуствует";
        this.price = 0;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public String getWhatWereDone() {
        return whatWereDone;
    }

    public void setWhatWereDone(String whatWereDone) {
        this.whatWereDone = whatWereDone;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
