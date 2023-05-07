package com.qendel.authenticationservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@AllArgsConstructor
@Data
@Entity
public class Admin extends AppUser {

//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;
    public Admin(String firstName, String lastName, String email, String password, UserRole userRole) {
        super(firstName, lastName, email, password, userRole);
    }

}
