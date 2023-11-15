package com.example.primaryqualifierannotations.controllers;

import com.example.primaryqualifierannotations.services.interfaces.BasicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 @RestController for API (Web Services, RESTful Endpoints)
 */
@RestController
public class HomeController {

    // Declaration of a private field to hold the injected instance of FirstServiceImpl
    private BasicService firstService;

    // @Autowired setter method for dependency injection.
    // The @Qualifier annotation is used here to specify the exact bean to be injected
    // when there are multiple beans of the same type (FirstService).
    @Autowired
    public void setFirstService(BasicService firstService) {
        // Setting the injected instance of FirstService to the private field firstService
        this.firstService = firstService;
    }

    @GetMapping("/first")
    public String getString() {
        return firstService.get();
    }
}
