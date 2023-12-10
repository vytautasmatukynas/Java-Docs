package com.example.serverandsqlconnection.controllers;

import com.example.serverandsqlconnection.models.User;

import lombok.RequiredArgsConstructor;


/*
@RequiredArgsConstructor is a Lombok annotation in Java that automatically generates
a constructor for a class based on the non-null final fields or, in other words, fields
marked with "final" and @NonNull annotations.
 */
@RequiredArgsConstructor
public class UserController {

    private final User user;

}
