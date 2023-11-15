package com.example.primaryqualifierannotations.controllers;

import com.example.primaryqualifierannotations.services.interfaces.BasicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecondContoller {

    // Declaration of a private field to hold the injected instance of FirstServiceImpl
    private BasicService secondService;

    // Autowired setter method for dependency injection.
    // The @Qualifier annotation is used here to specify the exact bean to be injected
    // when there are multiple beans of the same type (FirstService).
    @Autowired
    public void setSecondService(@Qualifier("secondServiceImpl") BasicService secondServ) {
        // Setting the injected instance of FirstService to the private field firstService
        this.secondService = secondServ;
    }

    @GetMapping("/second")
    public String getString() {
        return secondService.get();
    }
}
