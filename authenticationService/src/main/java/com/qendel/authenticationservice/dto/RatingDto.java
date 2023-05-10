package com.qendel.authenticationservice.dto;

import com.qendel.authenticationservice.model.Student;
import com.qendel.authenticationservice.model.Tutor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RatingDto {
    private RatingTutorDto tutor;
    private Integer rating;
//    private String comment;
//
//    private Student student;

}
