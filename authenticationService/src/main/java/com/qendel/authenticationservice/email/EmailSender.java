package com.qendel.authenticationservice.email;

public interface EmailSender {
    void send(String to, String email);
}
