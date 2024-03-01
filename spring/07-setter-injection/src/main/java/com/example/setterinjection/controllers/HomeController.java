package com.example.setterinjection.controllers;


import com.example.setterinjection.services.interfaces.BasicService;
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
    @Autowired
    public void setFirstService(BasicService firstService) {
        // Setting the injected instance of FirstService to the private field firstService
        this.firstService = firstService;
    }

    @GetMapping("/")
    public String getString() {
        return firstService.get();
    }
}
