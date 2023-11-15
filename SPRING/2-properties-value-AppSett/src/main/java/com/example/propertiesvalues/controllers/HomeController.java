package com.example.propertiesvalues.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    /*
    Inject properties value with "@Values" from "application.settings"
     */

    @Value("${first.name}")
    private String fistName;

    @Value("${last.name}")
    private String lastName;

    @GetMapping("/")
    public String hello() {
        return fistName + " " + lastName;
    }
}
