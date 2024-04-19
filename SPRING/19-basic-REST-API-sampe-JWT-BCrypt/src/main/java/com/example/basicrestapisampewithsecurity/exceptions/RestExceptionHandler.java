package com.example.basicrestapisampewithsecurity.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Collections;

/**
 * Global exception handler for RESTful API controllers.
 */
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    /**
     * Handles all unhandled exceptions and returns a standardized error response.
     *
     * @param ex The exception that occurred.
     * @param request The web request.
     * @return ResponseEntity with an ApiError containing information about the error.
     */
    @ExceptionHandler({Exception.class})
    public ResponseEntity<ApiError> handleAll(Exception ex, WebRequest request) {
        // Create an ApiError object with a general error message and internal server error status
        ApiError apiError = new ApiError(
                HttpStatus.INTERNAL_SERVER_ERROR,
                ex.getLocalizedMessage(),
                Collections.singletonList("A general error has occurred."));

        // Return a ResponseEntity with the ApiError, HTTP headers, and status
        return new ResponseEntity<>(apiError, new HttpHeaders(), apiError.getStatus());
    }

}
