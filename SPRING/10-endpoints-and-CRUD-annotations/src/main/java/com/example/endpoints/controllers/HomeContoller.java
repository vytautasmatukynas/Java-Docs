package com.example.endpoints.controllers;

import com.example.endpoints.models.Sample;

import org.springframework.web.bind.annotation.*;

/*
@RestController - used to define a class as a controller in a Spring MVC (Model-View-Controller)
application for REST API.
@RequestMapping("/home") - allows you to define the URI pattern that the controller or specific
methods will handle.
 */

@RestController
// http://localhost:8080/home
@RequestMapping("/home")
public class HomeContoller {

    // http://localhost:8080/home/get
    @GetMapping("/get")
    public String get() {
        return "GET ALL"; // Result: "GET ALL"
    }

    // http://localhost:8080/home/get/1
    @GetMapping("/get/{id}")
    public String getWithPath(@PathVariable String id) {
        return "GET ALL ID: " + id; // Result: "GET ALL ID: 1"
    }

    // http://localhost:8080/home/add/1/jonas
    @GetMapping("/add/{id}/{name}")
    public String postGreetingPath(@PathVariable long id, @PathVariable String name) {
        return id + ": " + name; // Result: "1: jonas"
    }

    // http://localhost:8080/home/add
    // Result: "Sample: Text"
    // http://localhost:8080/home/add/jonas/worker
    // Result: "jonas: worker"
    @GetMapping("/add")
    public String postGreetingParams(@RequestParam(value = "name", defaultValue = "Sample") String name,
                                 @RequestParam(value = "title", defaultValue = "Text") String title) {

        return name + ": " + title;
    }

    // http://localhost:8080/home/delete/1
    @DeleteMapping("/delete/{id}")
    public String delPath(@PathVariable long id) {
        return "delete: " + id;
    }

    // POST should be used with @RequestBody
    @PostMapping("/add")
    public Sample postSample(@RequestBody Sample sample) {
        return sample;
    }

    // http://localhost:8080/home/update/post/1
    @PutMapping("/update/post/{id}")
    public Sample putSample(@PathVariable long id, @RequestBody Sample sample) {
        return sample;
    }

    // http://localhost:8080/home/update/patch/1
    @PatchMapping("/update/patch/{id}")
    public String patch(@PathVariable long id) {
        return "patch: " + id;
    }

    // http://localhost:8080/info/jonas
    // This is same as @GetMapping
    // OLD SCHOOL Mapping... Like when dinosaurs were alive....
    @RequestMapping(value = "/info/{name}", method = RequestMethod.GET)
    public String getInfo(@PathVariable String name) {
        return "Hello " + name; // Result: "Hello jonas"
    }

}
