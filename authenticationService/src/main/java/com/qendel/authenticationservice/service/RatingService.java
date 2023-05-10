package com.qendel.authenticationservice.service;

import com.qendel.authenticationservice.dto.RatingCommentDto;
import com.qendel.authenticationservice.dto.RatingDto;
import com.qendel.authenticationservice.dto.RatingDtos;
import com.qendel.authenticationservice.model.Rating;
import com.qendel.authenticationservice.model.Tutor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.OptionalDouble;

public interface RatingService {
     RatingDtos createRating(Rating rating) ;
//     List<Rating > findByHighestRating(Integer rates);
     List<RatingDto> findByHighestRating(Integer rates);
     List<RatingCommentDto> searchTutorByReview(String  review);
     List<Rating> getRatingByTutor(Tutor tutor);
     Rating findByTutorId(Long tutorId);
    //public OptionalDouble getAverageRatingByTutor(Tutor tutor)

     void deleteRating(Long id);
}
