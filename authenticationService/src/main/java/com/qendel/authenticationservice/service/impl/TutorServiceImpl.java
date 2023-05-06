package com.qendel.authenticationservice.service.impl;

import com.qendel.authenticationservice.exception.TutorNotFoundException;
import com.qendel.authenticationservice.model.Tutor;
import com.qendel.authenticationservice.repository.TutorRepository;
import com.qendel.authenticationservice.service.TutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TutorServiceImpl implements TutorService {

    @Autowired
    private TutorRepository tutorRepository;

    @Override
    public Tutor createTutor(Tutor tutor) {
        return tutorRepository.save(tutor);
    }

    @Override
    public Tutor searchTutorByName(String name) {
        return tutorRepository.getTutorByFirstName(name);
    }

    @Override
    public List<Tutor> getAllTutors() {
        return tutorRepository.findAll();
    }

    @Override
    public Tutor getTutorById(Long id) {
        //return tutorRepository.findById(id).orElseThrow(null);
        return tutorRepository.findById(id).orElseThrow(() -> new TutorNotFoundException(id));
    }

    @Override
    public Tutor updateTutor(Long id, Tutor tutor) {
        Tutor existingTutor = tutorRepository.findById(id).orElseThrow(() -> new TutorNotFoundException(id));
        existingTutor.setFirstName(tutor.getFirstName());
        existingTutor.setLastName(tutor.getLastName());
        existingTutor.setSubject(tutor.getSubject());
        return tutorRepository.save(existingTutor);
    }

    @Override
    public void deleteTutor(Long id) {
        Tutor tutor = tutorRepository.findById(id).orElseThrow(() -> new TutorNotFoundException(id));
        tutorRepository.delete(tutor);
    }
}
