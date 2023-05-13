package com.qendel.authenticationservice.service.impl;

import com.qendel.authenticationservice.dto.StudentDto;
import com.qendel.authenticationservice.dto.TutorDto;
import com.qendel.authenticationservice.email.EmailSender;
import com.qendel.authenticationservice.model.Admin;
import com.qendel.authenticationservice.repository.AdminRepository;
import com.qendel.authenticationservice.repository.StudentRepository;
import com.qendel.authenticationservice.repository.TutorRepository;
import com.qendel.authenticationservice.service.AdminService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private TutorRepository tutorRepository;
    @Autowired
    private EmailSender emailSender;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<TutorDto> findAllTutor() {
        var allTutor = tutorRepository.findAll();

        return allTutor.stream()
                .map(n -> modelMapper.map(n, TutorDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteTutorById(Long id) {
        var tutor = tutorRepository.findById(id);
        if(tutor.isEmpty()){
            System.out.println("There is no tutor with the tutor id " + id);
        }
        tutorRepository.deleteById(id);
    }

    @Override
    public List<StudentDto> findAllStudent() {
      var allStudent = studentRepository.findAll();
        return allStudent.stream()
                .map(n -> modelMapper.map(n, StudentDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteStudentById(Long id) {
        var student = studentRepository.findById(id);
        if(student.isEmpty()){
            System.out.println("There is no tutor with the student id " + id);
        }
        studentRepository.deleteById(id);
    }

    @Override
    public Optional<TutorDto> findTutorById(Long id) {
        var tutor = tutorRepository.findById(id);
        return Optional.ofNullable(modelMapper.map(tutor, TutorDto.class));
    }

    @Override
    public Optional<StudentDto> findStudentById(Long id) {
        var student = studentRepository.findById(id);
        return Optional.ofNullable(modelMapper.map(student, StudentDto.class));
    }
}
