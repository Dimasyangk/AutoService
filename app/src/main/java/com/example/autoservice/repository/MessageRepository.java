package com.example.autoservice.repository;

import com.example.autoservice.mvvm.model.Message;
import com.example.autoservice.mvvm.model.Recording;

import java.util.ArrayList;

public class MessageRepository {
    private static MessageRepository instance;
    private int messageId = 26000000;

    public ArrayList<Message> messages = new ArrayList<>();

    public MessageRepository() {
    }

    public static MessageRepository getInstance() {
        if (instance == null) {
            instance = new MessageRepository();
        }
        return instance;
    }


    public void addMessage(String text, int authorId, int receiverId) {
        messages.add(new Message(messageId, text, authorId, receiverId));
        this.messageId++;
    }

    public ArrayList<Message> getConversationByUserId(int userId) {
        ArrayList<Message> conversation = new ArrayList<>();

        Message message1 = new Message(messageId, "Привет!", 12, 1);
        messageId++;
        Message message2 = new Message(messageId, "Тевирп!", 1, 12);
        messageId++;
        conversation.add(message1);
        conversation.add(message2);
        /*
        for (Message message : messages) {
            if (message.getAuthorId() == userId || message.getReceiverId() == userId) {
                conversation.add(message);
            }
        }
        */
        return conversation;
    }
}
