package com.qendel.authenticationservice.repository;

import com.qendel.authenticationservice.model.Rating;
import com.qendel.authenticationservice.model.Tutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface RatingRepository extends JpaRepository<Rating,Long> {

    List<Rating> findByTutor(Tutor tutor);
    Rating findByTutorId(Long tutorId);


}
