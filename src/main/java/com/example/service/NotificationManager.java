package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationManager {
    private final List<MessageService> messageService;

    @Autowired
    public NotificationManager(List<MessageService> messageService) {
        this.messageService = messageService;
    }

    public void notify (String message, String recipient) {
        messageService.forEach(service -> service.sendMessage(message, recipient));
    }
}
