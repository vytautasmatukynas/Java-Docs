package com.example.constructorinjection.controllers;

import com.example.constructorinjection.services.interfaces.FirstService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 @RestController for API (Web Services, RESTful Endpoints)
 */
@RestController
public class HomeController {

    /*
     Declare a dependency on the FirstService interface.
     This dependency will be injected by the Spring IoC (Inversion of Control) container.
     */
    private final FirstService firstService;

    /*
     Constructor-based dependency injection.
     The @Autowired annotation is not explicitly used, as of Spring 4.3,
     it's not required for constructor injection if there's only one constructor.
     */
    public HomeController(FirstService firstService) {
        // Assign the injected FirstService instance to the local variable.
        this.firstService = firstService;
    }

    @GetMapping("/")
    public String getString() {
        return firstService.get();
    }
}
