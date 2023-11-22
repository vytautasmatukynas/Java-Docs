package com.example.securityconfigurationjwtbcrypt.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/demo")
@RequiredArgsConstructor
public class DemoController {

    /**
     * Handles GET requests to "/api/demo" endpoint.
     *
     * @return ResponseEntity with a greeting message if the user has either "ADMIN" or "USER" role.
     * @throws ResponseStatusException with HttpStatus.FORBIDDEN if the user does not have sufficient privileges.
     */
    @GetMapping
    public ResponseEntity<String> sayHello() {
        // Retrieve the current authentication information
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // Check if the user has either "ADMIN" or "USER" role
        if (authentication.getAuthorities().stream().anyMatch(r -> r.getAuthority().equals("ADMIN") ||
                r.getAuthority().equals("USER"))) {

            // User has sufficient privileges, return a greeting message
            return ResponseEntity.ok("Hello, you are secure here");

        } else {
            // User does not have sufficient privileges, throw Forbidden status exception
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Access denied. Insufficient privileges.");
        }
    }

    /**
     * Handles GET requests to "/api/demo" endpoint.
     *
     * @return ResponseEntity with a greeting message if the user has "ADMIN" role.
     * @throws ResponseStatusException with HttpStatus.FORBIDDEN if the user does not have sufficient privileges.
     */
    @GetMapping
    public ResponseEntity<String> sayBye() {
        // Retrieve the current authentication information
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // Check if the user has either "ADMIN" or "USER" role
        if (authentication.getAuthorities().stream().anyMatch(r -> r.getAuthority().equals("ADMIN"))) {

            // User has sufficient privileges, return a greeting message
            return ResponseEntity.ok("Bye, you are too secure here");

        } else {
            // User does not have sufficient privileges, throw Forbidden status exception
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Access denied. Insufficient privileges.");
        }
    }
}
