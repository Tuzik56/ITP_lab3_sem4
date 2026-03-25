package com.example.controller;

import com.example.service.EmailService;
import com.example.service.NotificationManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class NotificationController {

    @GetMapping("/notify")
    public String notify(@RequestParam String message, @RequestParam String email) {
        NotificationManager manager = new NotificationManager(new EmailService());
        manager.notify(message, email);
        return "Уведомление отправлено (жесткая связь)";
    }
}
