package com.example.onetoonehibernate.repositories;

import com.example.onetoonehibernate.models.InstructorDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructorDetailRepository extends JpaRepository<InstructorDetail, Long> {
}
