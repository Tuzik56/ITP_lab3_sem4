package com.example.service;

public class PushService implements MessageService {
    @Override
    public void sendMessage(String message, String recipient) {
        System.out.printf("PUSH to %s: %s%n", recipient, message);
    }
}
