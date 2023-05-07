package com.qendel.authenticationservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tutors")
public class Tutor extends AppUser {

    private String subject;

    @OneToMany
    @JoinColumn(name="tutor_id")
    private List<Video> videos;

    public Tutor(String firstName, String lastName, String email, String password, UserRole userRole) {
        super(firstName, lastName, email, password, userRole);
    }

}
