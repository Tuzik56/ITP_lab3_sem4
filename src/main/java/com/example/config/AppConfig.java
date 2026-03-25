package com.example.config;

import com.example.service.EmailService;
import com.example.service.NotificationManager;
import com.example.service.PushService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public EmailService emailService() {
        return new EmailService();
    }

    @Bean
    public PushService pushService() {
        return new PushService();
    }

    @Bean
    public NotificationManager notificationManager() {
        return new NotificationManager(pushService());
    }
}
