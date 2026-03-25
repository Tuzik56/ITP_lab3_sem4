package com.example.service;

public class NotificationManager {
    private final MessageService messageService;

    public NotificationManager(MessageService service) {
        this.messageService = service;
    }

    public void notify (String message, String recipient) {
        messageService.sendMessage(message, recipient);
    }
}
