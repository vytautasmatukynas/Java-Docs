package com.example.serversettings.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    /*
    127.0.0.1:7070/sample
    Look at "application.settings"
     */
    @GetMapping("/")
    public String hello() {
        return "HELLO";
    }
}
