package com.codeacademy.javau7.crud.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/greeting")
public class FirstController {
    
    @GetMapping("/get")
    public String getGreetingParam() {
        return "GET";
    }

    @PostMapping("/add")
    public String postGreeting() {
        return "ADD";
    }

    @DeleteMapping("/delete")
    public String delGreetingParams() {
        return "DELETE";
    }

    @PatchMapping("/update/patch")
    public String patchGreeting() {
        return "PATCH";
    }

    @PutMapping("/update/put")
    public String putGreeting() {
        return "PUT";
    }

}
