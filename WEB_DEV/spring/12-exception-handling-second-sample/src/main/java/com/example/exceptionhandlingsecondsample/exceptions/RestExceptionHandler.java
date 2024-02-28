package com.example.exceptionhandlingsecondsample.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Collections;

/**
 * Global exception handler for RESTful services.
 */
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    /**
     * Exception handler for handling all types of exceptions.
     * @param ex The exception to handle.
     * @param request The web request.
     * @return ResponseEntity containing the ApiError object with appropriate status code and message.
     */
    @ExceptionHandler({Exception.class})
    public ResponseEntity<ApiError> handleAll(Exception ex, WebRequest request) {
        ApiError apiError = new ApiError(
                HttpStatus.INTERNAL_SERVER_ERROR,
                ex.getLocalizedMessage(),
                Collections.singletonList("A general error has occurred."));
        return new ResponseEntity<>(apiError, new HttpHeaders(), apiError.status());
    }
}
