package com.qendel.regisrationservice.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class User {
    private long id;
    private String firstName;
    private String lastName;
    private int age;
    private char gender;

}
