package com.qendel.authenticationservice.dto;

import com.qendel.authenticationservice.model.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RatingDtos {
    private RatingTutorDto tutor;
    private Integer rating;
    private String comment;
//
   private Student student;

}
