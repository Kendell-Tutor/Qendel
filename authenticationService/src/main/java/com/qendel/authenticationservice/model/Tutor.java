package com.qendel.authenticationservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter@Setter
@AllArgsConstructor@NoArgsConstructor
@Entity
@Table(name="tutors")
public class Tutor  extends AppUser{
    @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String subject;

    public Tutor(String firstName, String lastName, String email, String password, UserRole userRole) {
        super(firstName,lastName,email,password,userRole);
    }

    // private String firstName;
   // private String lastName;
   // private String email;
    //private String phone;
}
