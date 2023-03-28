package com.kendeltutoring.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Tutoring {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String experience;
    private String Course;
//    @Embedded
//    private Address address;

    public Tutoring(String firstName, String lastName, String experience, String course) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.experience = experience;
        Course = course;
//        this.address = address;
    }
}
