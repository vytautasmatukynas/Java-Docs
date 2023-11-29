package com.example.onetomanyhibernate.services;

import com.example.onetomanyhibernate.models.Course;
import com.example.onetomanyhibernate.models.Instructor;

import java.util.List;

public interface AppService {

    List<Instructor> get();

    Instructor getInstructor(Long instructorId);

    List<Course> getCourses(Long instructorId);

    Instructor getInstructorByCourse(Long courseId);

    void save(Instructor instructor);

    void update(Long instructorId, String firstName, String lastName, String email);

    void saveCourse(Long instructorId, String course);

    void updateCourse(Long instructorId, Long courseId, String newCourseTitle);

    void delete(Long instructorId);

    void deleteCourseById(Long instructorId, Long courseId);

}
