package com.myproject.bookmanagementsystem.service.impl;

import com.myproject.bookmanagementsystem.payload.request.LoginRequest;
import com.myproject.bookmanagementsystem.payload.request.RegisterRequest;
import com.myproject.bookmanagementsystem.payload.response.AuthenticationResponse;
import com.myproject.bookmanagementsystem.service.AuthenticationService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    @Override
    public AuthenticationResponse register(RegisterRequest request) {
        return null;
    }

    @Override
    public AuthenticationResponse login(LoginRequest request) {
        return null;
    }

    @Override
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) {

    }
}
