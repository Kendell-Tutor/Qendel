package com.qendel.authenticationservice.controller;

import com.qendel.authenticationservice.model.Tutor;
import com.qendel.authenticationservice.service.TutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/tutors")
public class TutorController {

    @Autowired
    private TutorService tutorService;

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public List<Tutor> getAllTutors() {
        return tutorService.getAllTutors();
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Tutor searchByTutorName(@RequestParam String name) {
        return tutorService.searchTutorByName(name);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Tutor getTutorById(@PathVariable Long id) {
        return tutorService.getTutorById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Tutor createTutor(@RequestBody  @Valid Tutor tutor) {
        return tutorService.createTutor(tutor);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Tutor updateTutor(@PathVariable Long id, @RequestBody Tutor tutor) {
        return tutorService.updateTutor(id, tutor);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTutor(@PathVariable Long id) {
        tutorService.deleteTutor(id);
    }

}

