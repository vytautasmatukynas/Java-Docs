package com.example.exceptionhandling.exceptions;

import lombok.Data;

import java.util.List;

@Data
public class ApiErrorDTO {

    private int status;

    private String message;

    private long timeStamp;

}


