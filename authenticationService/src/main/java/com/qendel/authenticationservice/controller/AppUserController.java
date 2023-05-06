package com.qendel.authenticationservice.controller;

import com.qendel.authenticationservice.dto.AppUserDto;
import com.qendel.authenticationservice.model.AppUser;
import com.qendel.authenticationservice.model.Tutor;
import com.qendel.authenticationservice.model.User;
import com.qendel.authenticationservice.service.AppUserService;

import com.qendel.authenticationservice.model.Video;

import com.qendel.authenticationservice.service.impl.AppUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(path = "/api/v1/users")
public class AppUserController {

    @Autowired
    private AppUserService service;

    @GetMapping("/admin")
   // @PreAuthorize("hasRole('ADMIN')")
    public String adminAccess() {
        return "Admin Board.";
    }

    @GetMapping("/student")
    //@PreAuthorize("hasRole('STUDENT')")
    public String studentAccess() {
        return "Student Board.";
    }

    @GetMapping("/search")
    //@PreAuthorize("hasRole('STUDENT')")
    public Tutor searchTutorByName(@RequestParam String name) {

        return service.searchTutorNameByUser(name);
    }
    @GetMapping("/tutor")
   // @PreAuthorize("hasRole('TUTOR')")
    public String tutorAccess() {
        return "Tutor Board.";
    }

    @GetMapping
    public String allAccess() {
        return "Public Content.";
    }
    @GetMapping("/admin/all")
   // @PreAuthorize("hasRole('ADMIN')")
    public List<AppUserDto> findAllUsers() {
        var allUsers = service.findAllUsers();
        if (allUsers.isEmpty()) {
            System.out.println("There is no user registered at this time");
        }
        return allUsers;
    }
    //@PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin/id/{id}")
    public Optional<AppUserDto> findUserById(@PathVariable Long id) {
        var user = service.findUserById(id);
        if (!user.isPresent()) {
            System.out.println("There is no user registered with the id  : " + id + " at this time");
        }
        return user;
    }
    //@PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin/name/{name}")
    public Optional<AppUserDto> findUserByName(@PathVariable String name) {
        var user = service.findUserByName(name);
        if (!user.isPresent()) {
            System.out.println("There is no user registered with the name : " + name + " at this time");
        }
        return user;
    }
    //@PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin/role/{role}")
    public List<AppUserDto> findAllUsersByRoles(@PathVariable String role) {
        var user = service.findAllUsersByRole(role);
        if (!user.isEmpty()) {
            System.out.println("There is no user registered with the role " + role + " at this time");
        }
        return user;
    }
    //@PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin/email/{email}")
    public Optional<AppUserDto> findUserByEmail(@PathVariable String email) {
        var user = service.findUserByEmail(email);
        if (!user.isPresent()) {
            System.out.println("There is no user registered with the email : " + email + " at this time");
        }
        return user;
    }

    @GetMapping("/admin/students")
    //@PreAuthorize("hasRole('ADMIN')")
    public List<AppUserDto> getAllStudents(){
        return service.findAllUsers();
    }
    @GetMapping("/view/{id}")
    //@PreAuthorize("hasRole('ADMIN')")
    public AppUserDto viewProfile(@PathVariable Long id){
        return service.viewProfile(id);
    }
    @PutMapping("/update/{id}")
    //@PreAuthorize("hasRole('ADMIN')")
    public AppUserDto updateProfile(@PathVariable Long id, @RequestBody AppUser appUser){
        return service.updateProfile(id,appUser);
    }

    @GetMapping("/search/{price}")
    public List<Video> searchVideosByPrice(@PathVariable int price){
        return service.searchVideosByPrice(price);
    }
}
