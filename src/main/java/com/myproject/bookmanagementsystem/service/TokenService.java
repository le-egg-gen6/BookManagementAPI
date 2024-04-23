package com.myproject.bookmanagementsystem.service;

import com.myproject.bookmanagementsystem.model.User;

public interface TokenService {

    boolean isTokenValid(String token);

    void saveUserToken(User user, String jwt);

    void revokeAllUserTokens(User user);

}
