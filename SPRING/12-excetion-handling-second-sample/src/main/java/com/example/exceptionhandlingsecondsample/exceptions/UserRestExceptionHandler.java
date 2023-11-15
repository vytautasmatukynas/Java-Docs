package com.example.exceptionhandlingsecondsample.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Collections;

@ControllerAdvice
public class UserRestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiErrorDTO> handleInternal(Exception ex, WebRequest request) {
        ApiErrorDTO apiError = new ApiErrorDTO(
                HttpStatus.INTERNAL_SERVER_ERROR,
                ex.getLocalizedMessage(),
                Collections.singletonList("A general error has occurred"));
        return new ResponseEntity<>(apiError, new HttpHeaders(), apiError.getStatus());
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ApiErrorDTO> handleNotFound(Exception ex, WebRequest request) {
        ApiErrorDTO apiError = new ApiErrorDTO(
                HttpStatus.NOT_FOUND,
                ex.getLocalizedMessage(),
                Collections.singletonList("A general error has occurred"));
        return new ResponseEntity<>(apiError, new HttpHeaders(), apiError.getStatus());
    }

}
