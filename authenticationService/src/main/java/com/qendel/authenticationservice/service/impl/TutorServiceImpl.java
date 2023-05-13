package com.qendel.authenticationservice.service.impl;

import com.qendel.authenticationservice.dto.StudentDto;
import com.qendel.authenticationservice.dto.TutorDto;
import com.qendel.authenticationservice.email.EmailSender;
import com.qendel.authenticationservice.exception.TutorNotFoundException;
import com.qendel.authenticationservice.model.Admin;
import com.qendel.authenticationservice.model.Student;
import com.qendel.authenticationservice.model.Tutor;
import com.qendel.authenticationservice.repository.StudentRepository;
import com.qendel.authenticationservice.repository.TutorRepository;
import com.qendel.authenticationservice.service.TutorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class TutorServiceImpl implements TutorService {


    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private TutorRepository tutorRepository;
    @Autowired
    private EmailSender emailSender;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public TutorDto createTutor(Tutor tutor) {
        var newTutor = tutorRepository.save(tutor);
        return modelMapper.map(newTutor,TutorDto.class);
    }

    @Override
    public TutorDto searchTutorByName(String name) {
        var tutor = tutorRepository.getTutorByFirstName(name);
        return modelMapper.map(tutor,TutorDto.class);
    }

    @Override
    public List<TutorDto> getAllTutors() {
        var allTutor = tutorRepository.findAll();
        return allTutor.stream()
                .map(n -> modelMapper.map(n, TutorDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public TutorDto getTutorById(Long id) {
        //return tutorRepository.findById(id).orElseThrow(null);
        var tutor = tutorRepository.findById(id).orElseThrow(() -> new TutorNotFoundException(id));
        return modelMapper.map(tutor,TutorDto.class);
    }

    @Override
    public TutorDto updateTutor(Long id, Tutor tutor) {

        Optional<Tutor> updateStudent = tutorRepository.findById(id);

        if (updateStudent.isPresent()) {
            Tutor user = updateStudent.get();
            user.setFirstName(tutor.getFirstName());
            user.setLastName(tutor.getLastName());
            user.setEmail(tutor.getEmail());
            user.setLocked(tutor.getLocked());
            user.setEnabled(tutor.getEnabled());
            user.setPhoneNumber(tutor.getPhoneNumber());
            user.setGender(tutor.getGender());
            user.setDateOfBirth(tutor.getDateOfBirth());
            tutorRepository.save(user);
            return modelMapper.map(user, TutorDto.class);
        } else {
            return null;
        }
    }

    @Override
    public void deleteTutor(Long id) {
        Tutor tutor = tutorRepository.findById(id).orElseThrow(() -> new TutorNotFoundException(id));
        tutorRepository.delete(tutor);
    }

    @Override
    public StudentDto viewStudentProfile(String name) {
        var student = studentRepository.findStudentByFirstName(name);
        return modelMapper.map(student,StudentDto.class);
    }

}
