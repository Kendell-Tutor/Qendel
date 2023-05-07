package com.qendel.authenticationservice.controller;

import com.qendel.authenticationservice.dto.AppUserDto;
import com.qendel.authenticationservice.dto.StudentDto;
import com.qendel.authenticationservice.dto.TutorDto;
import com.qendel.authenticationservice.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(path = "/api/v1/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public String adminAccess() {
        return "Admin Board.";
    }

    @GetMapping("/tutor/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Optional<TutorDto> findTutorById(@PathVariable Long id) {
        var tutor = adminService.findTutorById(id);
        if (!tutor.isPresent()) {
            System.out.println("There is no Tutor registered with the id  : " + id + " at this time");
        }
        return tutor;
    }

    @GetMapping("/student/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public Optional<StudentDto> findStudentById(@PathVariable Long id) {
        var student = adminService.findStudentById(id);
        if (!student.isPresent()) {
            System.out.println("There is no Student registered with the id  : " + id + " at this time");
        }
        return student;
    }

    @GetMapping("/students")
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<StudentDto> getAllStudents() {
        return adminService.findAllStudent();
    }

    @GetMapping("/tutors")
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<TutorDto> getAllTutor() {
        return adminService.findAllTutor();
    }

    @DeleteMapping("/delete/student/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void deleteStudent(@PathVariable Long id) {
        adminService.deleteStudentById(id);
    }
    @DeleteMapping("/delete/tutor/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void deleteTutor(@PathVariable Long id) {
        adminService.deleteTutorById(id);
    }
}
