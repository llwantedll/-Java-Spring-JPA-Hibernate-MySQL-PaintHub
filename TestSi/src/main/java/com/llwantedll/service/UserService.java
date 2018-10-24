package com.llwantedll.service;

import com.llwantedll.model.entities.User;

import java.util.List;

public interface UserService {
    void save(User user);
    List<User> getAllUsers();
    User getUser(Long id);
    User getUserByLogin(String login);
    User getUserByEmail(String email);
    void deleteUser(Long id);
}
