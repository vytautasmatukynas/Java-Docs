package com.example.onetomanyhibernate.services;

import com.example.onetomanyhibernate.repositories.AppRepository;
import com.example.onetomanyhibernate.models.Course;
import com.example.onetomanyhibernate.models.Instructor;
import com.example.onetomanyhibernate.repositories.CourseRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppServiceImpl implements AppService{

    private final AppRepository appRepository;
    private final CourseRepository courseRepository;

    public AppServiceImpl(AppRepository appRepository, CourseRepository courseRepository) {
        this.appRepository = appRepository;
        this.courseRepository = courseRepository;
    }

    public List<Instructor> get() {
        return appRepository.findAll();
    }

    public Instructor getInstructor(Long instructorId) {
        return appRepository.findById(instructorId)
                .orElseThrow(() -> new EntityNotFoundException("Instructor not found with id: " + instructorId));
    }

    @Override
    public List<Course> getCourses(Long instructorId) {
        Instructor instructor = appRepository.findById(instructorId)
                .orElseThrow(() -> new EntityNotFoundException("Instructor not found with id: " + instructorId));

        return instructor.getCourses();
    }

    @Override
    public Instructor getInstructorByCourse(Long courseId) {
        return courseRepository.findById(courseId)
                .orElseThrow(() -> new EntityNotFoundException("Instructor not found with course id: " + courseId))
                .getInstructor();
    }

    @Override
    public void save(Instructor instructor) {
        appRepository.save(instructor);
    }

    @Override
    public void update(Long instructorId, String firstName, String lastName, String email) {
        Instructor getInstructor = appRepository.findById(instructorId)
                .orElseThrow(() -> new EntityNotFoundException("Instructor not found with id: " + instructorId));

        getInstructor.setFirstName(firstName);
        getInstructor.setLastName(lastName);
        getInstructor.setEmail(email);

        appRepository.save(getInstructor);
    }

    @Override
    public void saveCourse(Long instructorId, String course) {
        Instructor instructor = appRepository.findById(instructorId)
                .orElseThrow(() -> new EntityNotFoundException("Instructor not found with id: " + instructorId));

        Course newCourse = new Course(course);

        instructor.add(newCourse);

        appRepository.save(instructor);
    }

    @Override
    public void updateCourse(Long instructorId, Long courseId, String newCourseTitle) {
        Instructor instructor = appRepository.findById(instructorId)
                .orElseThrow(() -> new EntityNotFoundException("Instructor not found with id: " + instructorId));

        // Find the course by courseId
        Course courseToUpdate = instructor.getCourses().stream()
                .filter(course -> course.getId() == courseId)
                .findFirst()
                .orElseThrow(() -> new EntityNotFoundException("Course not found with id: " + courseId));

        // Update the course title
        courseToUpdate.setTitle(newCourseTitle);

        // Save the updated instructor to the repository
        appRepository.save(instructor);
    }

    @Override
    public void delete(Long instructorId) {
        appRepository.deleteById(instructorId);
    }

    @Override
    public void deleteCourseById(Long instructorId, Long courseId) {
        Instructor instructor = appRepository.findById(instructorId)
                .orElseThrow(() -> new EntityNotFoundException("Instructor not found with id: " + instructorId));

        List<Course> courses = instructor.getCourses();

        courses.removeIf(course -> course.getId().equals(courseId));

        appRepository.save(instructor);
    }

}
