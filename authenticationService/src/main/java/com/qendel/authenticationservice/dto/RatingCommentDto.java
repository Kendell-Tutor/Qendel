package com.qendel.authenticationservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RatingCommentDto {
    private RatingTutorDto tutor;
    //private Integer rating;
   private String comment;
//
//    private Student student;

}
