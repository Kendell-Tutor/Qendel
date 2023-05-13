package com.qendel.authenticationservice.controller;

import com.qendel.authenticationservice.dto.RatingCommentDto;
import com.qendel.authenticationservice.dto.RatingDto;
import com.qendel.authenticationservice.dto.RatingDtos;
import com.qendel.authenticationservice.model.Rating;
import com.qendel.authenticationservice.model.Tutor;
import com.qendel.authenticationservice.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/api/v1/ratings")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @PostMapping("/post")
    @PreAuthorize("hasAuthority('STUDENT')")
    public ResponseEntity<RatingDtos> createRating(@RequestBody @Valid Rating rating) {
        RatingDtos savedRating = ratingService.createRating(rating);
        return new ResponseEntity<>(savedRating, HttpStatus.CREATED);
    }

    @GetMapping
    @PreAuthorize("hasAnyAuthority('STUDENT','TUTOR')")
    public ResponseEntity<List<RatingDto>>  getByHighestRatings(@RequestParam Integer rates) {
        List<RatingDto> highestRate= ratingService.findByHighestRating(rates);
        return new ResponseEntity<>(highestRate, HttpStatus.OK);
    }
    @GetMapping("/review")
    @PreAuthorize("hasAnyAuthority('ADMIN','STUDENT','TUTOR')")
    public ResponseEntity<List<RatingCommentDto>>  getByHighestRatings(@RequestParam String reviews) {
        List<RatingCommentDto> tutorReview= ratingService.searchTutorByReview(reviews);
        return new ResponseEntity<>(tutorReview, HttpStatus.OK);
    }



    @GetMapping("/tutors/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN','STUDENT','TUTOR')")
    public ResponseEntity<List<Rating>> getRatingsByTutor(@PathVariable Long id) {
        Tutor tutor = new Tutor();
        tutor.setId(id);
        List<Rating> ratings = ratingService.getRatingByTutor(tutor);
        return new ResponseEntity<>(ratings, HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN','STUDENT')")
    public void deleteRating(@PathVariable Long id) {
        ratingService.deleteRating(id);
    }
}
