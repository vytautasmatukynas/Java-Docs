package com.example.onetomanyhibernate.controllers;

import com.example.onetomanyhibernate.dtos.RequestCourseDTO;
import com.example.onetomanyhibernate.dtos.RequestInstructorDTO;
import com.example.onetomanyhibernate.models.Course;
import com.example.onetomanyhibernate.models.Instructor;
import com.example.onetomanyhibernate.services.AppService;
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

    @GetMapping("/all")
    public List<Instructor> getAllInstructors() {
        return appService.get();
    }

    @GetMapping("/{instructorId}")
    public Instructor getInstructorById(@PathVariable Long instructorId) {
        return appService.getInstructor(instructorId);
    }

    @GetMapping("/{instructorId}/courses")
    public List<Course> getCoursesForInstructor(@PathVariable Long instructorId) {
        return appService.getCourses(instructorId);
    }

    @GetMapping("/{courseId}/instructor")
    public ResponseEntity<Instructor> getInstructorForCourse(@PathVariable Long courseId) {
        return ResponseEntity.ok(appService.getInstructorByCourse(courseId));
    }

    @PostMapping("/add")
    public ResponseEntity<Instructor> saveInstructor(@RequestBody Instructor instructor) {
        appService.save(instructor);
        return ResponseEntity.ok(instructor);
    }

    @PostMapping("/{instructorId}/courses")
    public ResponseEntity<RequestCourseDTO> saveCourse(@PathVariable Long instructorId,
                                                       @RequestBody RequestCourseDTO requestCourseDTO) {

        appService.saveCourse(instructorId, requestCourseDTO.getTitle());

        return ResponseEntity.ok(requestCourseDTO);
    }

    @PutMapping("/{instructorId}")
    public ResponseEntity<RequestInstructorDTO> updateInstructor(@PathVariable Long instructorId,
                                                                 @RequestBody RequestInstructorDTO requestInstructorDTO){
        appService.update(instructorId, requestInstructorDTO.getFirstName(), requestInstructorDTO.getLastName(),
                requestInstructorDTO.getEmail());

        return ResponseEntity.ok(requestInstructorDTO);
    }

    @PutMapping("/{instructorId}/courses/{courseId}")
    public ResponseEntity<RequestCourseDTO> updateCourse(@PathVariable Long instructorId,
                                                         @PathVariable Long courseId,
                                                         @RequestBody RequestCourseDTO requestCourseDTO) {
        appService.updateCourse(instructorId, courseId, requestCourseDTO.getTitle());

        return ResponseEntity.ok(requestCourseDTO);
    }

    @DeleteMapping("/{instructorId}")
    public ResponseEntity<String> deleteInstructor(@PathVariable Long instructorId) {
        appService.delete(instructorId);
        return ResponseEntity.ok("Instructor Deleted");
    }

    @DeleteMapping("/{instructorId}/courses/{courseId}")
    public ResponseEntity<String> deleteCourse(@PathVariable Long instructorId, @PathVariable Long courseId) {
        appService.deleteCourseById(instructorId, courseId);
        return ResponseEntity.ok("Course Deleted");
    }

}
