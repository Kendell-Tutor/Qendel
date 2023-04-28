package com.qendel.authenticationservice.email;

public interface EmailSender {
    //void send(String to, String email);
    void sendEMail(String toEmail, String subject, String body);
}
