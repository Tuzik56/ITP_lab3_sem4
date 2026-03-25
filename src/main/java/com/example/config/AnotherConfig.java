package com.example.config;

import com.example.service.SmsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AnotherConfig {

    @Bean
    public SmsService smsService() {
        return new SmsService();
    }
}
