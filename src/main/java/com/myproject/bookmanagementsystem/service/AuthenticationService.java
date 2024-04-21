package com.myproject.bookmanagementsystem.service;

import com.myproject.bookmanagementsystem.payload.request.LoginRequest;
import com.myproject.bookmanagementsystem.payload.request.RegisterRequest;
import com.myproject.bookmanagementsystem.payload.response.AuthenticationResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface AuthenticationService {

    AuthenticationResponse register(RegisterRequest request);

    AuthenticationResponse login(LoginRequest request);

    void refreshToken(HttpServletRequest request, HttpServletResponse response);

}
