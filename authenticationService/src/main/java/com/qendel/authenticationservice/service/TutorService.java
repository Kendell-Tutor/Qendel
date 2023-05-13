package com.qendel.authenticationservice.service;

import com.qendel.authenticationservice.dto.StudentDto;
import com.qendel.authenticationservice.dto.TutorDto;
import com.qendel.authenticationservice.model.Admin;
import com.qendel.authenticationservice.model.Student;
import com.qendel.authenticationservice.model.Tutor;

import java.util.List;

public interface TutorService {

     List<TutorDto> getAllTutors(); // ? admin
     TutorDto getTutorById(Long id); // ? admin

     TutorDto searchTutorByName(String name); // ? student , admin
     TutorDto createTutor(Tutor tutor);
     TutorDto updateTutor(Long id, Tutor tutor);
     void deleteTutor(Long id); // ? admin
     StudentDto viewStudentProfile(String name);

}
