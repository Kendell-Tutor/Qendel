package com.qendel.authenticationservice.repository;

import com.qendel.authenticationservice.model.Rating;
import com.qendel.authenticationservice.model.Tutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface RatingRepository extends JpaRepository<Rating,Long> {

    List<Rating> findByTutor(Tutor tutor);
    Rating findByTutorId(Long tutorId);

    @Query(nativeQuery = true, value = "SELECT * FROM auth_db.ratings WHERE rating = :rate")
    List<Rating> findRatingsWithHighestRating(@Param("rate") Integer rate);
    @Query(nativeQuery = true, value = "SELECT * FROM auth_db.ratings WHERE comment = :reviews")
    List<Rating> findTutorByReviews(@Param("reviews") String reviews);



}
