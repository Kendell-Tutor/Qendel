package com.qendel.authenticationservice.service;

import com.qendel.authenticationservice.model.Rating;
import com.qendel.authenticationservice.model.Tutor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.OptionalDouble;

public interface RatingService {
     Rating save(Rating rating) ;
     List<Rating> getRatingByTutor(Tutor tutor);
   Rating findByTutorId(Long tutorId);
    //public OptionalDouble getAverageRatingByTutor(Tutor tutor)

     void deleteRating(Long id);
}
