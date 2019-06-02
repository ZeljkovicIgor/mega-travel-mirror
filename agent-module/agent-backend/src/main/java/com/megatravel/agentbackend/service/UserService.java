package com.megatravel.agentbackend.service;

import com.megatravel.agentbackend.model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();
    User addUser(User user);
}
