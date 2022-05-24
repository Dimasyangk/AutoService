package com.example.autoservice.mvvm.viewModels;

import android.view.View;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.autoservice.mvvm.model.Recording;
import com.example.autoservice.repository.RecordingRepository;

import java.util.ArrayList;

public class HomeViewModel extends ViewModel {
    private RecordingRepository recordingRepository = RecordingRepository.getInstance();

    private MutableLiveData<ArrayList<Recording>> currentRecordings;

    public MutableLiveData<ArrayList<Recording>> getRecordings(View v) {
        if (currentRecordings == null) {
            currentRecordings = new MutableLiveData<ArrayList<Recording>>();
        }
        //currentRecordings.setValue(recordingRepository.getUserRecordings(1));
        currentRecordings.setValue(recordingRepository.getUserRecordings(1));

        return currentRecordings;
    }
}
