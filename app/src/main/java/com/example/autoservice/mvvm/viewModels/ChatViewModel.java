package com.example.autoservice.mvvm.viewModels;

import android.view.View;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.autoservice.mvvm.model.Message;
import com.example.autoservice.repository.MessageRepository;

import java.util.ArrayList;

public class ChatViewModel extends ViewModel {
    private MessageRepository repository = MessageRepository.getInstance();

    private MutableLiveData<ArrayList<Message>> currentMessages;

    public MutableLiveData<ArrayList<Message>> getMessages(View view) {
        if (currentMessages == null) {
            currentMessages = new MutableLiveData<ArrayList<Message>>();
        }
        currentMessages.setValue(repository.getConversationByUserId(1));

        return currentMessages;
    }

    public void sendMessage(String text) {
        repository.addMessage(text, 1, 12);
    }
}
