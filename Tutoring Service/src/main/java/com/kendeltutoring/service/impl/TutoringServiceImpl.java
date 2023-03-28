package com.kendeltutoring.service.impl;

import com.kendeltutoring.model.Tutoring;
import com.kendeltutoring.service.TutoringService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TutoringServiceImpl implements TutoringService {
    @Override
    public List<Tutoring> getAllTutoring() {
        return null;
    }

    @Override
    public Tutoring getTutorBy_Id(Long tutorId) {
        return null;
    }

    @Override
    public Tutoring addNewTutor(Tutoring tutor) {
        return null;
    }

    @Override
    public Tutoring updateTutorDetails(Long tutorId, Tutoring tutor) {
        return null;
    }

    @Override
    public void deleteTutorById(Long tutorId) {

    }
}
