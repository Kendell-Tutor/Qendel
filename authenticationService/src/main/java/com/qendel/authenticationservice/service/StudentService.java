package com.qendel.authenticationservice.service;

import com.qendel.authenticationservice.dto.StudentDto;
import com.qendel.authenticationservice.model.Student;
import com.qendel.authenticationservice.model.Video;

import java.util.List;

public interface StudentService {
    StudentDto viewProfile(String name);
    void createAccount(Student student);
    StudentDto updateStudentProfile(Long id, Student student);

}
