package com.qendel.authenticationservice.controller;

import com.qendel.authenticationservice.model.AppUser;
import com.qendel.authenticationservice.service.impl.AppUserService;
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
    public List<AppUser> findAllUsers() {
        var allUsers = service.findAllUsers();
        allUsers.forEach(System.out::println);
        if (allUsers.isEmpty()) {
            System.out.println("There is no user registered at this time");
        }
        return allUsers;
    }
    //@PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin/id/{id}")
    public Optional<AppUser> findUserById(@PathVariable Long id) {
        var user = service.findUserById(id);
        if (!user.isPresent()) {
            System.out.println("There is no user registered with the id  : " + id + " at this time");
        }
        return user;
    }
    //@PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin/name/{name}")
    public Optional<AppUser> findUserByName(@PathVariable String name) {
        var user = service.findUserByName(name);
        if (!user.isPresent()) {
            System.out.println("There is no user registered with the name : " + name + " at this time");
        }
        return user;
    }
    //@PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin/role/{role}")
    public List<AppUser> findAllUsersByRoles(@PathVariable String role) {
        var user = service.findAllUsersByRole(role);
        if (!user.isEmpty()) {
            System.out.println("There is no user registered with the role " + role + " at this time");
        }
        return user;
    }
    //@PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin/email/{email}")
    public Optional<AppUser> findUserByEmail(@PathVariable String email) {
        var user = service.findUserByEmail(email);
        if (!user.isPresent()) {
            System.out.println("There is no user registered with the email : " + email + " at this time");
        }
        return user;
    }

    @GetMapping("/admin/students")
    //@PreAuthorize("hasRole('ADMIN')")
    public List<AppUser> getAllStudents(){
        return service.findAllUsers();
    }

//    @GetMapping("/tutors")
//    @PreAuthorize("hasRole('ADMIN')")
//    public List<AppUser> getAllTutors(){
//        return service.getAllTutors();
//    }

//    @GetMapping("/admin/{id}")
//    @PreAuthorize("hasRole('ADMIN')")
//    public AppUser getUserById(@PathVariable("id")Long id){
//        return service.findUserById(id).get();
//    }
//    @GetMapping("/username/{userName}")
//    @PreAuthorize("hasRole('ADMIN')")
//    public AppUser findUserByName(@PathVariable("userName")String userName){
//        return service.findUserByName(userName).get();
//    }
//    @GetMapping("/email/{email}")
//    @PreAuthorize("hasRole('ADMIN')")
//    public AppUser findUserByEmail(@PathVariable("email")String email){
//        return service.findUserByEmail(email).get();
//    }

//    @GetMapping("/admin/role/{role}")
//    @PreAuthorize("hasRole('ADMIN')")
//    public List<AppUser> getAllUserByRole(@PathVariable("role")String role){
//        return service.findAllUsersByRole(role);
//    }
}
