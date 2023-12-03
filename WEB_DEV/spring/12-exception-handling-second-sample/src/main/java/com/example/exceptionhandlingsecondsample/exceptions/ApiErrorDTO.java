package com.example.exceptionhandlingsecondsample.exceptions;

import org.springframework.http.HttpStatus;

import java.util.List;



public record ApiErrorDTO(HttpStatus status, String message, List<String> errors) {

    @Override
    public HttpStatus status() {
        return status;
    }

    @Override
    public String message() {
        return message;
    }

    @Override
    public List<String> errors() {
        return errors;
    }
}