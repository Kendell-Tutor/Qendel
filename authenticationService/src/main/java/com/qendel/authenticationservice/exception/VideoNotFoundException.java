package com.qendel.authenticationservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "There is not video exists with this id")
public class VideoNotFoundException extends RuntimeException {

}
