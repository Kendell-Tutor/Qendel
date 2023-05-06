package com.qendel.authenticationservice.model;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Student extends AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

   public Student(String firstName, String lastName, String email, String password, UserRole userRole) {
       super(firstName,lastName,email,password,userRole);
   }
}
