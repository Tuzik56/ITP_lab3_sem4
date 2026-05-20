package com.example.model.dto;

import com.example.model.entity.User;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class UserMapper {

    public UserDto toDto(User user) {

        return UserDto.builder()
                .name(user.getName())
                .email(user.getEmail())
                .phone(user.getPhone())
                .telegramChatId(user.getTelegramChatId())
                .deviceToken(user.getDeviceToken())
                .createdAt(user.getCreatedAt())
                .build();
    }

    public User toEntity(UserDto dto) {

        User user = new User();

        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPhone(dto.getPhone());
        user.setTelegramChatId(dto.getTelegramChatId());
        user.setDeviceToken(dto.getDeviceToken());
        user.setCreatedAt(dto.getCreatedAt());
        user.setCreatedAt(LocalDateTime.now());

        return user;
    }
}