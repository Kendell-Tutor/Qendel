package com.qendel.regisrationservice.service.impl;

import com.qendel.regisrationservice.model.Authentication;
import com.qendel.regisrationservice.repository.RegistrationRepository;
import com.qendel.regisrationservice.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationServiceImpl implements RegistrationService{

    @Autowired
    private RegistrationRepository repository;


    @Override
    public void createAccount(String userName, String password, String email) {

    }

    @Override
    public void login() {

    }

    @Override
    public void logout() {

    }

    @Override
    public Authentication getAccount(Long id) {
        return null;
    }

    @Override
    public Authentication updateAccount(Long id, Authentication authentication) {
        return null;
    }

    @Override
    public void deleteAccount(Long id) {

    }
}
