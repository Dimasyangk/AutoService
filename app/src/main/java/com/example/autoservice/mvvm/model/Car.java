package com.example.autoservice.mvvm.model;

public class Car {
    private String name, year, licensePlateNum;

    public Car(String name, String year, String licensePlateNum) {
        this.name = name;
        this.year = year;
        this.licensePlateNum = licensePlateNum;
    }

    public Car() {
        this.name = "ВАЗ 21130";
        this.year = "2002";
        this.licensePlateNum = "А 001 МР 77";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getLicensePlateNum() {
        return licensePlateNum;
    }

    public void setLicensePlateNum(String licensePlateNum) {
        this.licensePlateNum = licensePlateNum;
    }
}
