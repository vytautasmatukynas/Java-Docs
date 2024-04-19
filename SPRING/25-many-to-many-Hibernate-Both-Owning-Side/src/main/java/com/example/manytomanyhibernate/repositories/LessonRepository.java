package com.example.manytomanyhibernate.repositories;

import com.example.manytomanyhibernate.models.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LessonRepository extends JpaRepository<Lesson, Long> {

    Lesson findLessonByTitleContainsIgnoreCase(String title);

}
