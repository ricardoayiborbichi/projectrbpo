package ru.mtuci.projectrbpo.controller;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import ru.mtuci.projectrbpo.model.User;
import ru.mtuci.projectrbpo.repository.UserRepository;
import ru.mtuci.projectrbpo.security.JwtTokenProvider;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthController(AuthenticationManager authenticationManager,
                          JwtTokenProvider jwtTokenProvider,
                          UserRepository userRepository,
                          PasswordEncoder passwordEncoder) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/login")
    public Map<String, String> authenticateUser(@RequestBody Map<String, String> credentials) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        credentials.get("username"),
                        credentials.get("password")
                )
        );

        String token = jwtTokenProvider.generateToken(authentication);
        return Map.of("token", token);
    }

    @PostMapping("/register")
    public Map<String, String> registerUser(@RequestBody User user) {

        if (userRepository.existsByLogin(user.getLogin())) {
            return Map.of("error", "Login already exists");
        }
        if (userRepository.existsByEmail(user.getEmail())) {
            return Map.of("error", "Email already exists");
        }


        user.setPasswordHash(passwordEncoder.encode(user.getPasswordHash()));
        user.setRole("USER");


        userRepository.save(user);

        return Map.of("message", "User registered successfully");
    }
}

