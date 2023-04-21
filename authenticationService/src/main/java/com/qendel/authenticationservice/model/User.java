package com.qendel.authenticationservice.model;


import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String firstName;
    private String lastName;
    private int age;
    private char gender;
    private String userName;
    private String password;
    private String email;
    @OneToMany
    private List<Role> roles;

    public User(String firstName, String lastName, int age, char gender, String userName, String password, String email, List<Role> roles) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.roles = roles;
    }
}
