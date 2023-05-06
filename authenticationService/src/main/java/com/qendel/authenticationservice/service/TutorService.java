package com.qendel.authenticationservice.service;

import com.qendel.authenticationservice.model.Tutor;

import java.util.List;

public interface TutorService {

     List<Tutor> getAllTutors();
     Tutor getTutorById(Long id);

     Tutor searchTutorByName(String name);
     Tutor createTutor(Tutor tutor);
     Tutor updateTutor(Long id, Tutor tutor);
     void deleteTutor(Long id);
}
