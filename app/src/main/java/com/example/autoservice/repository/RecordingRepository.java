package com.example.autoservice.repository;

import com.example.autoservice.mvvm.model.Recording;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RecordingRepository {
    private static RecordingRepository instance;
    private int recordingCounter = 5000;

    public ArrayList<Recording> recordings = new ArrayList<>();

    public RecordingRepository() {

    }

    public static RecordingRepository getInstance() {
        if (instance == null) {
            instance = new RecordingRepository();
        }
        return instance;
    }
}
