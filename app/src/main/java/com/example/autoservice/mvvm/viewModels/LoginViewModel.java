package com.example.autoservice.mvvm.viewModels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.autoservice.mvvm.repos.UserRepository;

public class LoginViewModel extends ViewModel {

    private  final  UserRepository userRepos = new UserRepository();

    private final MutableLiveData<String> email = new MutableLiveData<>();
    private final MutableLiveData<String> password = new MutableLiveData<>();
    private final MutableLiveData<Boolean> access = new MutableLiveData<>();

    public MutableLiveData<String> getEmail() {
        return email;
    }

    public MutableLiveData<String> getPassword() {
        return password;
    }

    public MutableLiveData<Boolean> getAccess() {
        return access;
    }

    public String getUserNickName() {
        return userRepos.getActualUser().getNickname();
    }

    public void authorize (String email, String password) {
        access.setValue(userRepos.setActualUser(email,password));
    }
}
