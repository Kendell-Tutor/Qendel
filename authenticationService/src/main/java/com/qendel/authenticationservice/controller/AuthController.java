package com.qendel.authenticationservice.controller;

import com.qendel.authenticationservice.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private AppUserService appUserService;


    @PostMapping("/forgot-password")
    public String forgotPassword(@RequestParam String email) {

        String response = appUserService.forgotPassword(email);

        if (!response.startsWith("Invalid")) {
            response = "http://localhost:8080/reset-password?token=" + response;
        }
        return response;
    }

    @PutMapping("/reset-password")
    public String resetPassword(@RequestParam String token, @RequestParam String password) {
        System.out.println("New Password : " + password);
        return appUserService.resetPassword(token, password);
    }
}

