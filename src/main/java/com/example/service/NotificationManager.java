package com.example.service;

public class NotificationManager {
    private final MessageService messageService;

    public NotificationManager(MessageService messageService) {
        this.messageService = messageService;
    }

    public void notify (String message, String recipient) {
        messageService.sendMessage(message, recipient);
    }
}
