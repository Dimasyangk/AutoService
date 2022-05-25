package com.example.autoservice.mvvm.model;

import java.util.Date;

public class Recording {
    private int id;
    private int userId;
    private String city, name, telephoneNumber;
    private String reason;
    private Date date;
    private Car car;

    private String whatWereDone, comment;
    private int price;
    private Status status;

    private String doneWork;

    public Recording(int id, int userId, String city, String name, String telephoneNumber, String reason, Car car) {
        this.id = id;
        this.userId = userId;
        this.city = city;
        this.name = name;
        this.telephoneNumber = telephoneNumber;
        this.reason = reason;
        this.car = car;

        this.date = new Date();
        this.whatWereDone = "Пока работа не была проделана";
        this.comment = "Комментарий отсуствует";
        this.price = 0;
        this.status = Status.PROCESSING;

        this.doneWork = "Отсутсвует";
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getDoneWork() {
        return doneWork;
    }

    public void setDoneWork(String doneWork) {
        this.doneWork = doneWork;
    }

    public void addDoneWork(String doneWork) {
        this.doneWork = this.doneWork + ", " + doneWork;
    }
}
