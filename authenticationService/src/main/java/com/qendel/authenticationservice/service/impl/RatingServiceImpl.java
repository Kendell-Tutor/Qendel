package com.qendel.authenticationservice.service.impl;

import com.qendel.authenticationservice.dto.RatingCommentDto;
import com.qendel.authenticationservice.dto.RatingDto;
import com.qendel.authenticationservice.dto.RatingDtos;
import com.qendel.authenticationservice.model.AppUser;
import com.qendel.authenticationservice.model.Rating;
import com.qendel.authenticationservice.model.Student;
import com.qendel.authenticationservice.model.Tutor;
import com.qendel.authenticationservice.repository.AppUserRepository;
import com.qendel.authenticationservice.repository.RatingRepository;
import com.qendel.authenticationservice.repository.StudentRepository;
import com.qendel.authenticationservice.repository.TutorRepository;
import com.qendel.authenticationservice.service.RatingService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class RatingServiceImpl implements RatingService {

    @Autowired
    private RatingRepository ratingRepo;
    @Autowired
    private TutorRepository tutorRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private ModelMapper modelMapper;


    @Override
    public RatingDtos createRating(Rating rating) {
        Tutor extistingTutor= tutorRepository.findById(rating.getTutor().getId())
                .orElseThrow(()->new RuntimeException("Tutor not exist with this id: "+ rating.getTutor().getId()));
//        Student existingStudent=  studentRepository.findById(rating.getStudent().getId()).
//                orElseThrow(()->new RuntimeException("User not exist with id: "+ rating.getStudent().getId()));
         rating.setRating(rating.getRating());
         rating.setTutor(extistingTutor);
        // rating.setStudent(rating.getStudent());
         rating.setComment(rating.getComment());
        return modelMapper.map(ratingRepo.save(rating),RatingDtos.class);
    }

//    @Override
//    public  List<Rating>  findByHighestRating(Integer rate) {
//        return ratingRepo.findRatingsWithHighestRating(rate);
//    }

@Override
public  List<RatingDto>  findByHighestRating(Integer rate) {
        List<Rating> highestRating= ratingRepo.findRatingsWithHighestRating(rate);
    List<RatingDto> highestRatingDto = highestRating.stream()
            .map(rating -> modelMapper.map(rating, RatingDto.class))
            .collect(Collectors.toList());
    return highestRatingDto;
}

    @Override
    public List<RatingCommentDto> searchTutorByReview(String review) {
        List<Rating> tutorReview = ratingRepo.findTutorByReviews(review);
        return tutorReview.stream()
                .map(reviews->modelMapper.map(reviews,RatingCommentDto.class))
                .collect(Collectors.toList());
    }

    //    @Override
//    public  List<Rating>  findByHighestRating(Integer rate) {
//        List<Rating> allHighestRating=  ratingRepo.findAll();//tutorRepository.findAll();
//        return allHighestRating.stream().filter(r->r.getRating()>=rate).collect(Collectors.toList());
//    }
    @Override
    public Rating findByTutorId(Long tutorId) {
        return ratingRepo.findByTutorId(tutorId);
    }

    @Override
    public List<Rating> getRatingByTutor(Tutor tutor) {
        return ratingRepo.findByTutor(tutor);
    }
    @Override
    public void deleteRating(Long id) {
        ratingRepo.deleteById(id);
    }
    //    @Override
//    public  List<Rating>  findByHighestRating(Integer rate) {
//        List<Rating> allHighestRating=  ratingRepo.findAll();
//        Rating highest= allHighestRating.stream()
//                .max(Comparator.comparing(Rating::getRating))
//                .orElseThrow(()-> new RuntimeException(" Don't have highest rating"));
//        System.out.println(highest+" Hi from highest rating");
//        return highest;
//    }
}
