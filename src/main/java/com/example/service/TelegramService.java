package com.example.service;

import org.springframework.stereotype.Service;

@Service
public class TelegramService implements MessageService {
    @Override
    public void sendMessage(String message, String recipient) {
        System.out.printf("TELEGRAM to %s: %s%n", recipient, message);
    }
}
