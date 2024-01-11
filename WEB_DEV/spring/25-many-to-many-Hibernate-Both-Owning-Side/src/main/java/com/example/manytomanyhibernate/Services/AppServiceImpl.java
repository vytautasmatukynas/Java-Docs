package com.example.manytomanyhibernate.Services;

import com.example.manytomanyhibernate.models.Lesson;
import com.example.manytomanyhibernate.models.Teacher;
import com.example.manytomanyhibernate.repositories.LessonRepository;
import com.example.manytomanyhibernate.repositories.TeacherRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AppServiceImpl implements AppService{

    private final LessonRepository lessonRepository;
    private final TeacherRepository teacherRepository;

    public AppServiceImpl(LessonRepository lessonRepository, TeacherRepository teacherRepository) {
        this.lessonRepository = lessonRepository;
        this.teacherRepository = teacherRepository;
    }

    /**
     * Adds a lesson to a teacher's list of associated lessons.
     *
     * @param addName    The first name of the teacher.
     * @param addLesson  The title of the lesson to be added.
     */
    @Transactional
    @Override
    public void addLessonToTeacher(String addName, String addLesson) {
        // Retrieve the teacher and lesson entities based on the provided names.
        Teacher teacher = teacherRepository.findTeacherByFirstNameContainsIgnoreCase(addName);
        Lesson lesson = lessonRepository.findLessonByTitleContainsIgnoreCase(addLesson);

        // If both the teacher and lesson exist, associate the lesson with the teacher
        // and save the changes.
        if (teacher != null && lesson != null) {
            teacher.addLesson(lesson);
            teacherRepository.save(teacher);
        }
    }

    /**
     * Adds a teacher to a lesson's list of associated teachers.
     *
     * @param addLesson  The title of the lesson.
     * @param addName    The first name of the teacher to be added.
     */
    @Transactional
    @Override
    public void addTeacherToLesson(String addLesson, String addName) {
        // Retrieve the teacher and lesson entities based on the provided names.
        Teacher teacher = teacherRepository.findTeacherByFirstNameContainsIgnoreCase(addName);
        Lesson lesson = lessonRepository.findLessonByTitleContainsIgnoreCase(addLesson);

        // If both the teacher and lesson exist, associate the teacher with the lesson
        // and save the changes.
        if (teacher != null && lesson != null) {
            lesson.addTeacher(teacher);
            lessonRepository.save(lesson);
        }
    }

    /**
     * Removes a lesson from a teacher's list of associated lessons.
     *
     * @param removeName    The first name of the teacher.
     * @param removeLesson  The title of the lesson to be removed.
     */
    @Transactional
    @Override
    public void removeLessonFromTeacher(String removeName, String removeLesson) {
        // Retrieve the teacher and lesson entities based on the provided names.
        Teacher teacher = teacherRepository.findTeacherByFirstNameContainsIgnoreCase(removeName);
        Lesson lesson = lessonRepository.findLessonByTitleContainsIgnoreCase(removeLesson);

        // If both the teacher and lesson exist, disassociate the lesson from the teacher
        // and save the changes.
        if (teacher != null && lesson != null) {
            teacher.removeLesson(lesson);
            teacherRepository.save(teacher);
        }
    }

    /**
     * Removes a teacher from a lesson's list of associated teachers.
     *
     * @param removeLesson  The title of the lesson.
     * @param removeName    The first name of the teacher to be removed.
     */
    @Transactional
    @Override
    public void removeTeacherFromLesson(String removeLesson, String removeName) {
        // Retrieve the teacher and lesson entities based on the provided names.
        Teacher teacher = teacherRepository.findTeacherByFirstNameContainsIgnoreCase(removeName);
        Lesson lesson = lessonRepository.findLessonByTitleContainsIgnoreCase(removeLesson);

        // If both the teacher and lesson exist, disassociate the teacher from the lesson
        // and save the changes.
        if (teacher != null && lesson != null) {
            lesson.removeTeacher(teacher);
            lessonRepository.save(lesson);
        }
    }
}
