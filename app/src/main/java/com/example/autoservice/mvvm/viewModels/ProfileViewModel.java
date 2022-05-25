package com.example.autoservice.mvvm.viewModels;

import android.view.View;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.autoservice.mvvm.model.Recording;
import com.example.autoservice.mvvm.model.User;
import com.example.autoservice.repository.RecordingRepository;
import com.example.autoservice.repository.UserRepository;

import java.util.ArrayList;

public class ProfileViewModel extends ViewModel {
    private UserRepository userRepository = UserRepository.getInstance();
    private RecordingRepository recordingRepository = RecordingRepository.getInstance();

    private MutableLiveData<User> currentUser;
    private MutableLiveData<ArrayList<Recording>> currentDoneRecordings;

    public MutableLiveData<User> getCurrentUser() {
        if (currentUser == null) {
            currentUser = new MutableLiveData<User>();
        }
        currentUser.setValue(userRepository.getCurrentUser());

        return currentUser;
    }

    public MutableLiveData<ArrayList<Recording>> getDoneRecordings(View v) {
        if (currentDoneRecordings == null) {
            currentDoneRecordings = new MutableLiveData<ArrayList<Recording>>();
        }
        currentDoneRecordings.setValue(recordingRepository.getDoneUserRecordings(currentUser.getValue().getId()));

        return currentDoneRecordings;
    }
}
