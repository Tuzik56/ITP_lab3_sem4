package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class NotificationManager {
    private final Map<String, MessageService> messageServices;

    @Autowired
    public NotificationManager(Map<String, MessageService> messageServices) {
        this.messageServices = messageServices;
    }

    public void notify(String type, String message, String recipient) {

        MessageService service = messageServices.get(type);

        if (service != null) {
            service.sendMessage(message, recipient);
        } else {
            System.out.println("Сервис не найден: " + type);
        }
    }
}
