package com.qendel.authenticationservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND,reason = "This id isn't exits")
public class TutorNotFoundException  extends RuntimeException {

    public TutorNotFoundException(Long id) {
        System.out.println("This id: "+id+ "is not exist!");
    }
}