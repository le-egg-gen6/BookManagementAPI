package com.myproject.bookmanagementsystem.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.myproject.bookmanagementsystem.config.exception.ResourceNotFoundException;
import com.myproject.bookmanagementsystem.model.User;
import com.myproject.bookmanagementsystem.payload.request.LoginRequest;
import com.myproject.bookmanagementsystem.payload.request.RegisterRequest;
import com.myproject.bookmanagementsystem.payload.response.AuthenticationResponse;
import com.myproject.bookmanagementsystem.repository.TokenRepository;
import com.myproject.bookmanagementsystem.repository.UserRepository;
import com.myproject.bookmanagementsystem.security.service.JwtService;
import com.myproject.bookmanagementsystem.security.user.CustomUserDetails;
import com.myproject.bookmanagementsystem.service.AuthenticationService;
import com.myproject.bookmanagementsystem.service.TokenService;
import com.myproject.bookmanagementsystem.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TokenRepository tokenRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public AuthenticationResponse register(RegisterRequest request) {
        var user = User.builder()
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(request.getRole())
                .build();
        var savedUser = userRepository.save(user);
        CustomUserDetails userDetails = CustomUserDetails.builder()
                .username(savedUser.getUsername())
                .password(savedUser.getPassword())
                .id(savedUser.getId())
                .role(savedUser.getRole())
                .build();
        var jwtToken = jwtService.generateToken(userDetails);
        var refreshToken = jwtService.generateRefreshToken(userDetails);
        tokenService.saveUserToken(savedUser, jwtToken);
        return AuthenticationResponse.builder()
                .accessToken(jwtToken)
                .refreshToken(refreshToken)
                .build();
    }

    @Override
    public AuthenticationResponse login(LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );
        var user = userRepository.findByUsername(request.getUsername()).orElse(null);
        if (user == null) {
            throw new ResourceNotFoundException("User not found");
        } else {
            CustomUserDetails userDetails = CustomUserDetails.builder()
                    .username(user.getUsername())
                    .password(user.getPassword())
                    .id(user.getId())
                    .role(user.getRole())
                    .build();
            var jwtToken = jwtService.generateToken(userDetails);
            var refreshToken = jwtService.generateRefreshToken(userDetails);
            tokenService.revokeAllUserTokens(user);
            tokenService.saveUserToken(user, jwtToken);
            return AuthenticationResponse.builder()
                    .accessToken(jwtToken)
                    .refreshToken(refreshToken)
                    .build();
        }
    }

    //building
    @Override
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String refreshToken, username;
        refreshToken = jwtService.extractTokenFromRequest(request);
        username = jwtService.extractUsername(refreshToken);
        if (username != null) {
            var user = userRepository.findByUsername(username).orElse(null);
            if (user == null) {
                throw new ResourceNotFoundException("User not found");
            }
            CustomUserDetails userDetails = CustomUserDetails.builder()
                    .username(user.getUsername())
                    .password(user.getPassword())
                    .id(user.getId())
                    .role(user.getRole())
                    .build();
            if (jwtService.isTokenValid(refreshToken, userDetails)) {
                var accessToken = jwtService.generateToken(userDetails);
                tokenService.revokeAllUserTokens(user);
                tokenService.saveUserToken(user, accessToken);
                var authResponse = AuthenticationResponse.builder()
                        .accessToken(accessToken)
                        .refreshToken(refreshToken)
                        .build();
                new ObjectMapper().writeValue(response.getOutputStream(), authResponse);
            }
        }
    }
}
