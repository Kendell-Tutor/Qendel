package com.qendel.authenticationservice.controller;

import com.qendel.authenticationservice.dto.StudentDto;
import com.qendel.authenticationservice.model.Student;
import com.qendel.authenticationservice.model.Video;
import com.qendel.authenticationservice.service.AppUserService;
import com.qendel.authenticationservice.service.StudentService;
import com.qendel.authenticationservice.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Access;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(path = "/api/v1/students")
public class StudentController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private VideoService videoService;
    @Autowired
    private AppUserService appUserService;

    @GetMapping("/view/{name}")
    @PreAuthorize("hasAnyAuthority('ADMIN','STUDENT','TUTOR')")
    public StudentDto viewProfile(@PathVariable String name) {
        return studentService.viewProfile(name);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN','STUDENT','TUTOR')")
    public StudentDto getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    @PostMapping
    @PreAuthorize("hasAnyAuthority('ADMIN','STUDENT','TUTOR')")
    public void createNewAccount(@RequestBody Student student) {
        studentService.createAccount(student);
    }

    @PutMapping("/update/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN','STUDENT','TUTOR')") // todo --- ?
    public StudentDto viewProfile(@PathVariable Long id, @RequestBody Student student) {
        return studentService.updateStudentProfile(id, student);
    }

    @GetMapping("/video/all")
    @PreAuthorize("hasAnyAuthority('ADMIN','STUDENT','TUTOR')")
    public ResponseEntity<List<String>> getAllVideoNames() {
        return ResponseEntity.ok(videoService.getAllVideoNames());
    }

    @GetMapping("{/video/{name}")
    @PreAuthorize("hasAnyAuthority('ADMIN','STUDENT','TUTOR')")
    public ResponseEntity<Resource> getVideoByName(@PathVariable("name") String name) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(new ByteArrayResource(videoService.getVideo(name).getData()));
    }

    @GetMapping("/video/tutor/name/{name}")
    public ResponseEntity<List<Resource>> getAllVideosByTutorName(@PathVariable String name) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(videoService.getAllVideosByTutorName(name).stream()
                        .map(v -> new ByteArrayResource(v.getData()))
                        .collect(Collectors.toList()));
    }

    @GetMapping("/forgot_password")
    public String showForgotPasswordForm() {
        return null;
    }

    @PostMapping("/forgot_password")
    public String processForgotPassword() {

        return null;
    }

    @GetMapping("/reset_password")
    public String showResetPasswordForm() {
        return null;
    }

    @PostMapping("/reset_password")
    public String processResetPassword() {
        return null;
    }
}
