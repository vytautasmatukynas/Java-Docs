package com.example.onetoonehibernate.services;

import com.example.onetoonehibernate.models.Instructor;
import com.example.onetoonehibernate.models.InstructorDetail;

import java.util.List;

public interface AppService {

    void save(Instructor instructor);

    void delete(Long instructorId);

    void deleteDetails(Long instructorId);

    List<Instructor> getAll();

    Instructor getInstructor(Long instructorId);

    InstructorDetail getAllInstructorDetails(Long instructorId);

    Instructor getInstructorByDetails(Long detailsId);

    void updateInstructorDetails(Long instructorId, String youtubeChannel, String hobby);

    void updateInstructor(Long instructorId, String firstName, String lastName, String email);


}