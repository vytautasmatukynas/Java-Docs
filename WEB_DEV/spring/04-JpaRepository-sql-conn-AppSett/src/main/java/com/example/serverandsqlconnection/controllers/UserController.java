package com.example.serverandsqlconnection.controllers;

import com.example.serverandsqlconnection.models.User;
import com.example.serverandsqlconnection.repositories.UserRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

/*
@RestController for Web Pages and Views

@RequiredArgsConstructor is a Lombok annotation in Java that automatically generates
a constructor for a class based on the non-null final fields or, in other words, fields
marked with "final" and @NonNull annotations.
 */
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    @GetMapping("/getall")
    public List<User> getAll() {
        List<User> users = userRepository.findAll();

        if (users.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "No Users were found.");

        return users;
    }

    @GetMapping("/get/{id}")
    public User getUser(@PathVariable long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
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
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
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
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "There is no User with this ID."));
    }
}
