package com.codeacademy.javau7.crud.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/greetings")
public class FirstController {

    // This method handles HTTP GET requests to "/api/greetings/get"
    @GetMapping("/get")
    public String getGreetingParam() {
        return "GET";
    }

    // This method handles HTTP POST requests to "/api/greetings/add"
    @PostMapping("/add")
    public String postGreeting() {
        return "ADD";
    }

    // This method handles HTTP DELETE requests to "/api/greetings/delete"
    @DeleteMapping("/delete")
    public String delGreetingParams() {
        return "DELETE";
    }

    // This method handles HTTP PATCH requests to "/api/greetings/update/patch"
    @PatchMapping("/update/patch")
    public String patchGreeting() {
        return "PATCH";
    }

    // This method handles HTTP PUT requests to "/api/greetings/update/put"
    @PutMapping("/update/put")
    public String putGreeting() {
        return "PUT";
    }
}
