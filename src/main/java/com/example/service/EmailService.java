package com.example.service;

public class EmailService implements MessageService {
    @Override
    public void sendMessage(String message, String recipient) {
        System.out.printf("EMAIL to %s: %s%n", recipient, message);
    }
}
