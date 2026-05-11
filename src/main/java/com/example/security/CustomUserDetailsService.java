package com.example.security;

import lombok.RequiredArgsConstructor;
import com.example.model.entity.User;
import com.example.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws

            UsernameNotFoundException {
        User user = userRepository.findByEmail(username)
                .orElseThrow(() -> new
                        UsernameNotFoundException("Пользователь не найден"));

        return new CustomUserDetails(user);
    }
}