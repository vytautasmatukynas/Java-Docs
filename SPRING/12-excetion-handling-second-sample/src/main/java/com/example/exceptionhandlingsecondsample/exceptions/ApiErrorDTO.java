package com.example.exceptionhandlingsecondsample.exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.List;


@Data
public class ApiErrorDTO {
    private int status;
    private String message;
    private List<String> errors;

    public ApiErrorDTO(HttpStatus status, String message, List<String> errors) {
        this.status = status.value();
        this.message = message;
        this.errors = errors;
    }
}