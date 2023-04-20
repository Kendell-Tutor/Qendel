package com.qendel.regisrationservice.service;

import com.qendel.regisrationservice.model.Authentication;

public interface RegistrationService {
    void createAccount(String userName, String password, String email);
    void login();
    void logout();
    Authentication getAccount(Long id);
    Authentication updateAccount(Long id, Authentication authentication);
    void deleteAccount(Long id);
}
