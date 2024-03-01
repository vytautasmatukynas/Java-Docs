package com.example.manytomanyhibernate.controllers;

import com.example.manytomanyhibernate.Services.AppService;

import com.example.manytomanyhibernate.configs.AppConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

    private static final Logger logger = LoggerFactory.getLogger(AppConfig.class);
    private final AppService appService;


    public AppController(AppService appService) {
        this.appService = appService;
    }

    @PostMapping("/addLesson/{teacherName}/{lessonName}")
    public void addLessonToTeacher(@PathVariable String teacherName, @PathVariable String lessonName) {
        appService.addLessonToTeacher(teacherName, lessonName);

        logger.info("Lesson was added");
    }

    @PostMapping("/addTeacher/{lessonName}/{teacherName}")
    public void addTeacherToLesson(@PathVariable String lessonName, @PathVariable String teacherName) {
        appService.addTeacherToLesson(lessonName, teacherName);

        logger.info("Teacher was added");
    }

    @DeleteMapping("/removeLesson/{teacherName}/{lessonName}")
    public void removeLessonToTeacher(@PathVariable String teacherName, @PathVariable String lessonName) {
        appService.removeLessonFromTeacher(teacherName, lessonName);

        logger.info("Lesson was removed");
    }

    @DeleteMapping("/removeTeacher/{lessonName}/{teacherName}")
    public void removeTeacherToLesson(@PathVariable String lessonName, @PathVariable String teacherName) {
        appService.removeTeacherFromLesson(lessonName, teacherName);

        logger.info("Teacher was removed");
    }
}
