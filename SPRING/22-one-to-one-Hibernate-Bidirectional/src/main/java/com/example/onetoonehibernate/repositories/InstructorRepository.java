package com.example.onetoonehibernate.repositories;

import com.example.onetoonehibernate.models.Instructor;
import com.example.onetoonehibernate.models.InstructorDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Long> {

}