package com.example.service;

import org.springframework.stereotype.Service;

@Service
public class SmsService implements MessageService {
    @Override
    public void sendMessage(String message, String recipient) {
        System.out.printf("SMS to %s: %s%n", recipient, message);
    }
}
