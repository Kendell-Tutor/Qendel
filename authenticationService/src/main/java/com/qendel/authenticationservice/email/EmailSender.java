package com.qendel.authenticationservice.email;

public interface EmailSender {
    void sendEMail(String toEmail, String subject, String body);
}
