package com.llwantedll.service;

public interface SecurityService {
    String findLoggedInLogin();
    void autologin(String login, String password);
}
