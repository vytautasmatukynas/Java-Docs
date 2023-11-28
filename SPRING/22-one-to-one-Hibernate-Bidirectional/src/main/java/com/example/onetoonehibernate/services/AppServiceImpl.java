package com.example.onetoonehibernate.services;

import com.example.onetoonehibernate.models.Instructor;
import com.example.onetoonehibernate.models.InstructorDetail;
import com.example.onetoonehibernate.repositories.InstructorDetailRepository;
import com.example.onetoonehibernate.repositories.InstructorRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppServiceImpl implements AppService {

    private final InstructorRepository instructorRepository;
    private final InstructorDetailRepository instructorDetailRepository;

    public AppServiceImpl(InstructorRepository instructorRepository, InstructorDetailRepository instructorDetailRepository) {
        this.instructorRepository = instructorRepository;
        this.instructorDetailRepository = instructorDetailRepository;
    }

    @Override
    public List<Instructor> getAll() {
        return instructorRepository.findAll();
    }

    @Override
    public InstructorDetail getAllInstructorDetails(Long instructorId) {
        Instructor instructor = instructorRepository.findById(instructorId)
                .orElseThrow(() -> new EntityNotFoundException("Instructor not found with id: " + instructorId));

        return instructor.getInstructorDetail();
    }

    @Override
    public Instructor getInstructor(Long instructorId) {
        return instructorRepository.findById(instructorId)
                .orElseThrow(() -> new EntityNotFoundException("Instructor not found with id: " + instructorId));
    }

    @Override
    public Instructor getInstructorByDetails(Long detailsId) {
        return instructorDetailRepository.findById(detailsId)
                .orElseThrow(() -> new EntityNotFoundException("Instructor not found with id: " + detailsId))
                .getInstructor();
    }

    @Override
    @Transactional
    public void save(Instructor theInstructor) {
        instructorRepository.save(theInstructor);
    }

    @Override
    @Transactional
    public void delete(Long instructorId) {
        instructorRepository.deleteById(instructorId);
    }

    @Override
    @Transactional
    public void deleteDetails(Long instructorId) {
        Instructor instructor = instructorRepository.findById(instructorId)
                .orElseThrow(() -> new EntityNotFoundException("Instructor not found with id: " + instructorId));

        InstructorDetail instructorDetail = instructor.getInstructorDetail();

        if (instructorDetail != null) {
            instructor.setInstructorDetail(null);
            instructorDetailRepository.delete(instructorDetail);
        }
    }

    @Override
    @Transactional
    public void updateInstructorDetails(Long instructorId, String youtubeChannel, String hobby) {
        Instructor instructor = instructorRepository.findById(instructorId)
                .orElseThrow(() -> new EntityNotFoundException("Instructor not found with id: " + instructorId));

        instructor.updateInstructorDetail(youtubeChannel, hobby);
        instructorRepository.save(instructor);
    }

    @Override
    @Transactional
    public void updateInstructor(Long instructorId, String firstName, String lastName, String email) {
        Instructor instructor = instructorRepository.findById(instructorId)
                .orElseThrow(() -> new EntityNotFoundException("Instructor not found with id: " + instructorId));

        instructor.setFirstName(firstName);
        instructor.setLastName(lastName);
        instructor.setEmail(email);

        instructorRepository.save(instructor);
    }
}