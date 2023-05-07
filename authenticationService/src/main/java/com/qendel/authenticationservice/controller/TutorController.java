package com.qendel.authenticationservice.controller;

import com.qendel.authenticationservice.dto.TutorDto;
import com.qendel.authenticationservice.model.Tutor;
import com.qendel.authenticationservice.service.TutorService;
import com.qendel.authenticationservice.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(path = "/api/v1/tutors")
public class TutorController {

    @Autowired
    private TutorService tutorService;
    @Autowired
    private VideoService videoService;

    @GetMapping("/all")
    @PreAuthorize("hasAnyAuthority('ADMIN','TUTOR')")
    @ResponseStatus(HttpStatus.OK)
    public List<TutorDto> getAllTutors() {
        return tutorService.getAllTutors();
    }

    @GetMapping
    @PreAuthorize("hasAnyAuthority('ADMIN','TUTOR')")
    @ResponseStatus(HttpStatus.OK)
    public TutorDto searchByTutorName(@RequestParam String name) {
        return tutorService.searchTutorByName(name);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN','TUTOR')")
    @ResponseStatus(HttpStatus.OK)
    public TutorDto getTutorById(@PathVariable Long id) {
        return tutorService.getTutorById(id);
    }

    @PostMapping
    @PreAuthorize("hasAnyAuthority('ADMIN','TUTOR')")
    @ResponseStatus(HttpStatus.CREATED)
    public TutorDto createTutor(@RequestBody  @Valid Tutor tutor) {
        return tutorService.createTutor(tutor);
    }

    @PutMapping("/update/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN','TUTOR')")
    @ResponseStatus(HttpStatus.OK)
    public TutorDto updateTutor(@PathVariable Long id, @RequestBody Tutor tutor) {
        return tutorService.updateTutor(id, tutor);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN','TUTOR')")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTutor(@PathVariable Long id) {
        tutorService.deleteTutor(id);
    }


    @PostMapping("/video")
   // @PreAuthorize("hasAnyAuthority('TUTOR')") // todo temporary commented out to test uploading
    public ResponseEntity<String> saveVideo(@RequestParam("file") MultipartFile file, @RequestParam("name") String name, @RequestParam("price") int price) throws IOException {
        videoService.saveVideo(file, price, name);
        return ResponseEntity.ok("Video saved successfully.");
    }
}

