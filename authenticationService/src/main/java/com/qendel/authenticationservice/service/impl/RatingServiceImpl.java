package com.qendel.authenticationservice.service.impl;

import com.qendel.authenticationservice.model.AppUser;
import com.qendel.authenticationservice.model.Rating;
import com.qendel.authenticationservice.model.Tutor;
import com.qendel.authenticationservice.repository.AppUserRepository;
import com.qendel.authenticationservice.repository.RatingRepository;
import com.qendel.authenticationservice.repository.TutorRepository;
import com.qendel.authenticationservice.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RatingServiceImpl implements RatingService {
    @Autowired
    private RatingRepository ratingRepo;
    @Autowired
    private TutorRepository tutorRepository;
    @Autowired
    private AppUserRepository appUserRepository;


    @Override
    public Rating save(Rating rating) {
        Tutor extistingTutor= tutorRepository.findById(rating.getTutor().getId())
                .orElseThrow(()->new RuntimeException("Tutor not exist with this id: "+ rating.getTutor().getId()));
        AppUser existingUser=  appUserRepository.findById(rating.getUser().getId()).
                orElseThrow(()->new RuntimeException("User not exist with id: "+ rating.getUser().getId()));
         rating.setRating(rating.getRating());
         rating.setTutor(extistingTutor);
         rating.setUser(rating.getUser());
         rating.setComment(rating.getComment());
        return ratingRepo.save(rating);
    }
    @Override
    public Rating findByTutorId(Long tutorId) {
        return ratingRepo.findByTutorId(tutorId);
    }

    @Override
    public List<Rating> getRatingByTutor(Tutor tutor) {
        return ratingRepo.findByTutor(tutor);
    }



//    @Override
//    public List<Rating> findByUserId(Long userId) {
//        return ratingRepo.findByUserId(userId);
//    }

    @Override
    public void deleteRating(Long id) {
        ratingRepo.deleteById(id);
    }
}
