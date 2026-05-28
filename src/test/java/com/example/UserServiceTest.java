package com.example;

import com.example.model.entity.User;
import com.example.repository.UserRepository;
import com.example.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    void shouldGetUserById() {
        Long id = 1L;

        User foundUser = new User();
        foundUser.setId(id);

        when(userRepository.findById(id)).thenReturn(Optional.of(foundUser));

        User result = userService.getUserById(id);

        assertNotNull(result);
        assertEquals(id, result.getId());
    }

    @Test
    void shouldThrowExceptionWhenUserNotFound() {
        Long id = 1L;

        when(userRepository.findById(id)).thenReturn(Optional.empty());

        assertThrows(NoSuchElementException.class, () -> userService.getUserById(id));
    }

    @Test
    void shouldDeleteUser() {
        Long id = 1L;

        User deletedUser = new User();
        deletedUser.setId(id);

        when(userRepository.findById(id)).thenReturn(Optional.of(deletedUser));

        userService.deleteUser(id);

        verify(userRepository).delete(any(User.class));
    }
}