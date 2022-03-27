package com.ticketApp.ticketApp.service;

import com.ticketApp.ticketApp.dto.CredentialsDTO;
import com.ticketApp.ticketApp.dto.UserDTO;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.nio.CharBuffer;

@Service
public class AuthenticationService {
    private final PasswordEncoder passwordEncoder;

    public AuthenticationService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public UserDTO authenticate(CredentialsDTO credentialsDto) {
        String encodedMasterPassword = passwordEncoder.encode(CharBuffer.wrap("the-password"));
        if (passwordEncoder.matches(CharBuffer.wrap(credentialsDto.getPassword()), encodedMasterPassword)) {
            return new UserDTO(1L, "Ioana", "Miruna", "login", "token");
        }
        throw new RuntimeException("Invalid password");
    }

    public UserDTO findByLogin(String login) {
        if ("login".equals(login)) {
            return new UserDTO(1L, "Ioana", "Miruna", "login", "token");
        }
        throw new RuntimeException("Invalid login");
    }
}
