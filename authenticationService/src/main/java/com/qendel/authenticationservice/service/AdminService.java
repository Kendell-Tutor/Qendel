package com.qendel.authenticationservice.service;

import com.qendel.authenticationservice.dto.StudentDto;
import com.qendel.authenticationservice.dto.TutorDto;
import com.qendel.authenticationservice.model.Admin;
import com.qendel.authenticationservice.model.Student;
import com.qendel.authenticationservice.model.Tutor;

import java.util.List;
import java.util.Optional;

public interface AdminService {
    List<TutorDto> findAllTutor();
    void deleteTutorById(Long id);
    List<StudentDto> findAllStudent();
    void deleteStudentById(Long id);
    Optional<TutorDto> findTutorById(Long id);
    Optional<StudentDto> findStudentById(Long id);
}
