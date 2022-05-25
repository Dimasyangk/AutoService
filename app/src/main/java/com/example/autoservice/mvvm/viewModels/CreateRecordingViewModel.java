package com.example.autoservice.mvvm.viewModels;

import androidx.lifecycle.ViewModel;

import com.example.autoservice.mvvm.model.User;
import com.example.autoservice.repository.RecordingRepository;
import com.example.autoservice.repository.UserRepository;

public class CreateRecordingViewModel extends ViewModel {
    private RecordingRepository recordingRepository = RecordingRepository.getInstance();
    private UserRepository userRepository = UserRepository.getInstance();

    public void makeRecording(String city, String name, String num, String carName, String carYear, String carNum, String reason) {
        recordingRepository.addRecording(1,
                city,
                name,
                num,
                reason,
                carName,
                carYear,
                carNum);
    }

    public User getCurrentUser() {
        return userRepository.getCurrentUser();
    }
}
