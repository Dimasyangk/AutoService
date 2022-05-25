package com.example.autoservice.repository;

import com.example.autoservice.mvvm.model.Recording;
import com.example.autoservice.mvvm.model.User;

import java.util.ArrayList;

public class UserRepository {
    private static UserRepository instance;
    private int userCounter = 10000000;

    public ArrayList<User> users = new ArrayList<>();

    public UserRepository() {
        createTestUser();
    }

    public static UserRepository getInstance() {
        if (instance == null) {
            instance = new UserRepository();
        }
        return instance;
    }

    public void createTestUser() {
        User user = new User(1, "N/A", "N/A", "N/A");
        userCounter++;
        users.add(user);
    }

    public User getCurrentUser() {
        return users.get(0);
    }
}
