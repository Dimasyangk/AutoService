package com.example.autoservice.repository;

import com.example.autoservice.mvvm.model.Recording;
import com.example.autoservice.mvvm.model.User;

import java.util.ArrayList;

public class UserRepository {
    private static UserRepository instance;
    private int UserCounter = 10000000;

    public ArrayList<User> users = new ArrayList<>();

    public UserRepository() {

    }

    public static UserRepository getInstance() {
        if (instance == null) {
            instance = new UserRepository();
        }
        return instance;
    }
}
