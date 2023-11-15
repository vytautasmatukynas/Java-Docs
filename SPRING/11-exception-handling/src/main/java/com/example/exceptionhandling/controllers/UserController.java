package com.example.exceptionhandling.controllers;


import com.example.exceptionhandling.exceptions.UserNotFoundException;
import com.example.exceptionhandling.models.User;
import com.example.exceptionhandling.repositories.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

/*
@Controller for Web Pages and Views
 */
@RestController
public class UserController {

    UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/getall")
    public List<User> getAll() {
        List<User> users = userRepository.findAll();

        if (users.isEmpty())
            // Throw a ResponseStatusException with a NOT_FOUND status and a custom message,
            // including the caught exception for more information.
            // ResponseStatusException is a type of exception specifically designed to represent HTTP responses.
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "No Users were found.");

        return users;
    }

    @GetMapping("/get/{id}")
    public User getUser(@PathVariable long id) {
        return userRepository.findById(id)
                // If the user is not found, throw a UserNotFoundException with a NOT_FOUND status.
                // UserNotFoundException is a custom exception specifically designed to represent HTTP responses.
                // Look at exceptions package
                .orElseThrow(() -> new UserNotFoundException(HttpStatus.NOT_FOUND,
                        "There is no User with this ID."));
    }

    @GetMapping("/search/{text}")
    public List<User> search(@PathVariable String text) {
        List<User> users = userRepository.findByNameAndEmailContainingIgnoreCase(text, text);

        if (users.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "No book that you are searching. Please try again.");

        return users;
    }

    @PostMapping("/add")
    public User addUser(@RequestBody User user) {
        try {
            userRepository.save(user);
            return user;

        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error adding new User", e);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable long id) {
        return userRepository.findById(id)
                .map(User -> {
                    userRepository.deleteById(User.getId());
                    return ResponseEntity.ok(String.format("Message: User \"%s - %s\" deleted successfully.",
                            User.getName(), User.getEmail()));
                })
                .orElseThrow(() -> new UserNotFoundException(HttpStatus.NOT_FOUND,
                                                "There is no User with this ID."));
    }

    @PutMapping("/update/{id}")
    public User updateUser(@PathVariable long id, @RequestBody User userUpdate) {
        return userRepository.findById(id)
                .map(user -> {
                    user.setName(userUpdate.getName());
                    user.setEmail(userUpdate.getEmail());

                    userRepository.save(user);

                    return user;
                })
                .orElseThrow(() -> new UserNotFoundException(HttpStatus.NOT_FOUND,
                        "There is no User with this ID."));
    }
}
