package com.qendel.authenticationservice.Login;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class LoginResponse {
    private String message;
    private Boolean status;
}
