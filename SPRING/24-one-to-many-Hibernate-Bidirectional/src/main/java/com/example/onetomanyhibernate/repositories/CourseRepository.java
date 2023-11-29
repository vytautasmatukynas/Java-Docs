package com.example.onetomanyhibernate.repositories;

import com.example.onetomanyhibernate.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
}
