package com.example.onetoonehibernate.services;

import com.example.onetoonehibernate.models.Instructor;
import com.example.onetoonehibernate.models.InstructorDetail;

import java.util.List;

public interface AppService {

    void save(Instructor instructor);

    void deleteInstructor(Long instructorId);

    void deleteDetails(Long instructorId);

    List<Instructor> getAllInstructors();

    Instructor getInstructor(Long instructorId);

    InstructorDetail getAllInstructorDetails(Long instructorId);

    void updateInstructorDetails(Long instructorId, String youtubeChannel, String hobby);

    void updateInstructor(Long instructorId, String firstName, String lastName, String email);

}