package com.example.basicrestapisampewithsecurity.exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.List;


/**
 * Represents an error response in a RESTful API.
 */
@Data
public class ApiError {

    // The HTTP status code of the error response
    private int status;

    // A message describing the error
    private String message;

    // A list of specific error details
    private List<String> errors;

    /**
     * Constructs an ApiError object with the given parameters.
     *
     * @param status  The HTTP status code of the error.
     * @param message A message describing the error.
     * @param errors  A list of specific error details.
     */
    public ApiError(HttpStatus status, String message, List<String> errors) {
        this.status = status.value();
        this.message = message;
        this.errors = errors;
    }
}