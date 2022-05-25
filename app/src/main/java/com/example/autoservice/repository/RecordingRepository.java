package com.example.autoservice.repository;

import com.example.autoservice.mvvm.model.Car;
import com.example.autoservice.mvvm.model.Recording;
import com.example.autoservice.mvvm.model.Status;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RecordingRepository {
    private static RecordingRepository instance;
    private int recordingCounter = 5000;

    public ArrayList<Recording> recordings = new ArrayList<>();

    public RecordingRepository() {
        fillMockRecordings();
    }

    public static RecordingRepository getInstance() {
        if (instance == null) {
            instance = new RecordingRepository();
        }
        return instance;
    }

    public void addExistingRecording(Recording recording) {
        recordings.add(recording);
    }

    public void addRecording(
            int userId,
            String city,
            String name,
            String num,
            String reason,
            String carName,
            String carYear,
            String carNum) {
        Car car = new Car(carName, carYear, carNum);
        Recording recording = new Recording(recordingCounter, userId, city, name, num, reason, car);
        recordings.add(recording);
        recordingCounter++;
    }

    public Recording getRecordingById(int id) {
        Recording requiredRecording = null;

        for (Recording recording : recordings) {
            if (recording.getId() == id) {
                requiredRecording = recording;
            }
        }

        return requiredRecording;
    }

    public ArrayList<Recording> getUserRecordings(int userId) {
        ArrayList<Recording> userRecordings = new ArrayList<>();

        for (Recording recording : recordings) {
            if (recording.getUserId() == userId) {
                userRecordings.add(recording);
            }
        }

        return userRecordings;
    }

    public ArrayList<Recording> getDoneUserRecordings(int userId) {
        ArrayList<Recording> doneUserRecordings = new ArrayList<>();

        for (Recording recording : recordings) {
            if (recording.getUserId() == userId && recording.getStatus().equals(Status.DONE)) {
                doneUserRecordings.add(recording);
            }
        }

        return doneUserRecordings;
    }

    public ArrayList<Recording> getAllRecordings() {
        return recordings;
    }



    private void fillMockRecordings() {
        Recording recording1 = new Recording(
                recordingCounter,
                1,
                "Moscow",
                "Дмитрий",
                "+7 (924) 657-54-55",
                "Замена масла",
                new Car()
        );
        recordingCounter++;
        addExistingRecording(recording1);

        Recording recording2 = new Recording(
                recordingCounter,
                1,
                "Moscow",
                "Дмитрий",
                "+7 (924) 657-54-55",
                "Установка спойлера",
                new Car()
        );
        recordingCounter++;
        addExistingRecording(recording2);

        Recording recording3 = new Recording(
                recordingCounter,
                1,
                "Moscow",
                "Дмитрий",
                "+7 (924) 657-54-55",
                "Замена рулевой рейки",
                new Car()
        );
        recordingCounter++;
        addExistingRecording(recording3);

        Recording recording4 = new Recording(
                recordingCounter,
                1,
                "Moscow",
                "Дмитрий",
                "+7 (924) 657-54-55",
                "Капиталка",
                new Car()
        );
        recording4.getCar().setName("Volkswagen Polo");
        recording4.getCar().setYear("2010");
        recording4.getCar().setLicensePlateNum("А 001 ОО 77");
        recording4.setStatus(Status.DONE);
        recording4.addDoneWork("Заменена левая дверь полностью");
        recording4.addDoneWork("заменена головка ГБЦ");
        recordingCounter++;
        addExistingRecording(recording4);
    }
}
