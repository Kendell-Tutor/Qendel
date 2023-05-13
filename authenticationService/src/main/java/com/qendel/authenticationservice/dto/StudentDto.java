package com.qendel.authenticationservice.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.qendel.authenticationservice.model.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentDto {

    private String firstName;
    private String lastName;
    private String email;
    @Enumerated(EnumType.STRING)
    private UserRole userRole;
    private Boolean locked = false;
    private Boolean enabled = false;
    private String phoneNumber;
    private char gender;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;

}
