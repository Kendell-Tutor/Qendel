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
public class RatingTutorDto {

    private String firstName;
    private String lastName;
}
