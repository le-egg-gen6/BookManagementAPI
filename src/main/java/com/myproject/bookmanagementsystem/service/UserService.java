package com.myproject.bookmanagementsystem.service;

import com.myproject.bookmanagementsystem.model.User;

public interface UserService {

    User getUser();

    User saveUser(User user);

    User findByUsername(String username);

}
