package com.qendel.authenticationservice.registration;

public interface RegistrationService {
     String register(RegistrationRequest request);
     String confirmToken(String token);

}
