package com.qendel.authenticationservice.service.impl;

import com.qendel.authenticationservice.dto.AppUserDto;
import com.qendel.authenticationservice.dto.StudentDto;
import com.qendel.authenticationservice.model.AppUser;
import com.qendel.authenticationservice.model.Student;
import com.qendel.authenticationservice.model.Video;
import com.qendel.authenticationservice.repository.StudentRepository;
import com.qendel.authenticationservice.repository.VideoRepository;
import com.qendel.authenticationservice.service.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private VideoRepository videoRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public StudentDto viewProfile(String name) {
        var student = studentRepository.findStudentByFirstName(name);
        return modelMapper.map(student,StudentDto.class);
    }

    @Override
    public void createAccount(Student student) {
        studentRepository.save(student);
    }

    @Override
    public StudentDto updateStudentProfile(Long id, Student student) {
        Optional<Student> updateStudent = studentRepository.findById(id);

        if (updateStudent.isPresent()) {
            Student user = updateStudent.get();
            user.setFirstName(student.getFirstName());
            user.setLastName(student.getLastName());
            user.setEmail(student.getEmail());
            user.setLocked(student.getLocked());
            user.setEnabled(student.getEnabled());
            user.setPhoneNumber(student.getPhoneNumber());
            user.setGender(student.getGender());
            user.setDateOfBirth(student.getDateOfBirth());
            studentRepository.save(user);
            return modelMapper.map(user, StudentDto.class);
        } else {
            return null;
        }
    }


}
