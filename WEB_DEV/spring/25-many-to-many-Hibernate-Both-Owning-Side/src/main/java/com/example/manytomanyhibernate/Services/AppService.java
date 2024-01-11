package com.example.manytomanyhibernate.Services;

public interface AppService {

    void addLessonToTeacher(String addName, String addLesson);

    void addTeacherToLesson(String addName, String addLesson);

    void removeLessonFromTeacher(String removeName, String removeLesson);

    void removeTeacherFromLesson(String removeLesson, String removeName);
}
