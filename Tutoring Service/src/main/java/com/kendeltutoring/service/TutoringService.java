package com.kendeltutoring.service;

import com.kendeltutoring.model.Tutoring;

import java.util.List;

public interface TutoringService {

    List<Tutoring> getAllTutoring();
    Tutoring getTutorBy_Id(Long tutorId);
    Tutoring addNewTutor(Tutoring tutor);
    Tutoring updateTutorDetails(Long tutorId, Tutoring tutor);
    void deleteTutorById(Long tutorId);

    //List<Tutoring> searchTutorByCourse(String searchByCourse);
}
