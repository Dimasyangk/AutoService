package com.example.autoservice.mvvm.model;


import androidx.annotation.NonNull;

public class User {

    public  String email;
    public String password;
    public String nickname;
    public int id;

    public  User (int id, @NonNull String email, @NonNull String password, String nickname){
        this.id = id;
        this.email = email;
        this.password = password;
        if (nickname == null){
            this.nickname = "user/" + id;
        } else {
            this.nickname = nickname;
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}


