package com.example.manytomanyhibernate.repositories;

import com.example.manytomanyhibernate.models.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    Teacher findTeacherByFirstNameContainsIgnoreCase(String name);

}
