package com.example.exceptionhandling.exceptions;

import org.springframework.http.HttpStatus;

public class UserNotFoundException extends RuntimeException{

    private final HttpStatus status;

    public UserNotFoundException(HttpStatus status, String message) {
        super(message);
        this.status = status;
    }

    public UserNotFoundException(HttpStatus status, String message, Throwable cause) {
        super(message, cause);
        this.status = status;
    }

    public UserNotFoundException(HttpStatus status, Throwable cause) {
        super(cause);
        this.status = status;
    }

}
