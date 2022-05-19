package com.example.autoservice.mvvm.repos;

import com.example.autoservice.mvvm.model.User;

import java.util.ArrayList;

public class UserRepository {

    private final ArrayList<User> users = new ArrayList<>();

    private User ActualUser = null;

    public UserRepository () {
        users.add(new User(1,"fd@mail.ru","123","Ford"));
        users.add(new User(2,"gg@mail.ru","456","George"));
        users.add(new User(3,"mh@mail.ru","789","Michail;"));
    }

    public User getActualUser() {
        return ActualUser;
    }

    public boolean setActualUser(String email, String password) {
        for (User user: users) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)){
                this.ActualUser = user;
                return true;
            }
        }
        this.ActualUser=null;
        return false;
    }
}
