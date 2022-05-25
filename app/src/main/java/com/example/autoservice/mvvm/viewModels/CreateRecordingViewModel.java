package com.example.autoservice.mvvm.viewModels;

import androidx.lifecycle.ViewModel;

import com.example.autoservice.mvvm.model.Recording;
import com.example.autoservice.repository.RecordingRepository;

public class CreateRecordingViewModel extends ViewModel {
    private RecordingRepository repository = RecordingRepository.getInstance();

    public void makeRecording(String city, String name, String num, String carName, String carYear, String carNum, String reason) {
        repository.addRecording(1,
                city,
                name,
                num,
                reason,
                carName,
                carYear,
                carNum);
    }
}
