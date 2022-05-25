package com.example.autoservice.mvvm.viewModels;

import android.view.View;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.autoservice.mvvm.model.Message;
import com.example.autoservice.mvvm.model.User;
import com.example.autoservice.repository.MessageRepository;
import com.example.autoservice.repository.UserRepository;

import java.util.ArrayList;

public class ProfileViewModel extends ViewModel {
    private UserRepository repository = UserRepository.getInstance();

    private MutableLiveData<User> currentUser;

    public MutableLiveData<User> getCurrentUser() {
        if (currentUser == null) {
            currentUser = new MutableLiveData<User>();
        }
        currentUser.setValue(repository.getCurrentUser());

        return currentUser;
    }
}
