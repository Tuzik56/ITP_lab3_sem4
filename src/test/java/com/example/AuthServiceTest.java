package com.example;

import com.example.model.dto.RegisterRequest;
import com.example.model.entity.User;
import com.example.model.enums.UserRole;
import com.example.repository.UserRepository;
import com.example.service.AuthService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.server.ResponseStatusException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AuthServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    AuthService authService;

    @Test
    void shouldRegister() {
        RegisterRequest request = new RegisterRequest();
        request.setName("Ivan");
        request.setEmail("ivan@test.com");
        request.setPassword("123456");

        when(userRepository.existsByEmail(request.getEmail())).thenReturn(false);
        when(passwordEncoder.encode("123456")).thenReturn("encodedPassword");

        authService.register(request);

        ArgumentCaptor<User> captor = ArgumentCaptor.forClass(User.class);

        verify(userRepository, times(1)).save(captor.capture());

        User savedUser = captor.getValue();

        assertEquals("Ivan", savedUser.getName());
        assertEquals("ivan@test.com", savedUser.getEmail());
        assertEquals("encodedPassword", savedUser.getPassword());
        assertEquals(UserRole.ROLE_USER, savedUser.getRole());
    }

    @Test
    void shouldThrowResponseStatusException() {
        RegisterRequest request = new RegisterRequest();
        request.setName("Ivan");
        request.setEmail("ivan@test.com");
        request.setPassword("123456");

        when(userRepository.existsByEmail(request.getEmail())).thenReturn(true);

        assertThrows(ResponseStatusException.class, () -> authService.register(request));
    }

    @Test
    void shouldRegisterAdmin() {
        RegisterRequest request = new RegisterRequest();
        request.setName("Admin");
        request.setEmail("admin@test.com");
        request.setPassword("123456");

        when(userRepository.existsByEmail(any())).thenReturn(false);
        when(passwordEncoder.encode(any())).thenReturn("encoded");

        authService.registerAdmin(request);

        ArgumentCaptor<User> captor = ArgumentCaptor.forClass(User.class);

        verify(userRepository).save(captor.capture());

        User savedUser = captor.getValue();

        assertEquals(UserRole.ROLE_ADMIN, savedUser.getRole());
    }
}
