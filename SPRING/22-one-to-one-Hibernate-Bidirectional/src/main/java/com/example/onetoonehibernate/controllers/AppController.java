package com.example.onetoonehibernate.controllers;

import com.example.onetoonehibernate.dtos.UpdateDetailsRequest;
import com.example.onetoonehibernate.dtos.UpdateInstructorRequest;
import com.example.onetoonehibernate.models.Instructor;
import com.example.onetoonehibernate.models.InstructorDetail;
import com.example.onetoonehibernate.services.AppService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AppController {

    private final AppService appService;

    public AppController(AppService appService) {
        this.appService = appService;
    }

    // Get all instructors
    @GetMapping("/all")
    public ResponseEntity<List<Instructor>> getAllInstructors() {
        List<Instructor> instructors = appService.getAll();
        return ResponseEntity.ok(instructors);
    }

    // Get details for a specific instructor
    @GetMapping("/instructor/{instructorId}")
    public ResponseEntity<Instructor> getInstructor(@PathVariable Long instructorId) {
        try {
            Instructor instructor= appService.getInstructor(instructorId);
            return ResponseEntity.ok(instructor);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    // Get details for a specific instructor
    @GetMapping("/details/{instructorId}")
    public ResponseEntity<InstructorDetail> getInstructorDetails(@PathVariable Long instructorId) {
        try {
            InstructorDetail instructorDetails = appService.getAllInstructorDetails(instructorId);
            return ResponseEntity.ok(instructorDetails);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    // Get instructor for a specific details
    @GetMapping("/instructor-by-details/{detailsId}")
    public ResponseEntity<Instructor> getDetailsByInstructor(@PathVariable Long detailsId) {
        try {
            Instructor instructor = appService.getInstructorByDetails(detailsId);
            return ResponseEntity.ok(instructor);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    // Add a new instructor
    @PostMapping("/add")
    public ResponseEntity<Instructor> addInstructor(@RequestBody Instructor theInstructor) {
        appService.save(theInstructor);
        return ResponseEntity.ok(theInstructor);
    }

    // Update instructor details
    @PutMapping("/update/{instructorId}")
    public ResponseEntity<UpdateInstructorRequest> updateInstructor(
            @PathVariable Long instructorId,
            @RequestBody UpdateInstructorRequest updateInstructorRequest
    ) {
        try {
            appService.updateInstructor(instructorId,
                    updateInstructorRequest.getFirstName(),
                    updateInstructorRequest.getLastName(),
                    updateInstructorRequest.getEmail());
            return ResponseEntity.ok(updateInstructorRequest);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(updateInstructorRequest);
        }
    }

    // Update instructor details
    @PutMapping("/update-details/{instructorId}")
    public ResponseEntity<UpdateDetailsRequest> updateInstructorDetails(
            @PathVariable Long instructorId,
            @RequestBody UpdateDetailsRequest updateDetailsRequest
    ) {
        try {
            appService.updateInstructorDetails(instructorId,
                    updateDetailsRequest.getYoutubeChannel(),
                    updateDetailsRequest.getHobby());
            return ResponseEntity.ok(updateDetailsRequest);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(updateDetailsRequest);
        }
    }

    // Delete an instructor
    @DeleteMapping("/delete/{instructorId}")
    public ResponseEntity<String> deleteInstructor(@PathVariable Long instructorId) {
        try {
            appService.delete(instructorId);
            return ResponseEntity.ok("Instructor was deleted.");
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Instructor not found.");
        }
    }

    // Delete instructor details
    @DeleteMapping("/delete-details/{instructorId}")
    public ResponseEntity<String> deleteInstructorDetails(@PathVariable Long instructorId) {
        try {
            appService.deleteDetails(instructorId);
            return ResponseEntity.ok("Instructor details were deleted.");
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Instructor not found.");
        }
    }
}
