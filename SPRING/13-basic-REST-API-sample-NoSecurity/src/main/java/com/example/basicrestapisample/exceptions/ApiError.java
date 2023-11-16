package com.example.basicrestapisample.exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.List;


@Data
public class ApiError {
    private int status;
    private String message;
    private List<String> errors;

    public ApiError(HttpStatus status, String message, List<String> errors) {
        this.status = status.value();
        this.message = message;
        this.errors = errors;
    }
}