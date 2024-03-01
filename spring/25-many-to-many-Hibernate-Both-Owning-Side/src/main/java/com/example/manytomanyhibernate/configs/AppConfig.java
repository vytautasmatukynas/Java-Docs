package com.example.manytomanyhibernate.configs;

import com.example.manytomanyhibernate.models.Lesson;
import com.example.manytomanyhibernate.models.Teacher;
import com.example.manytomanyhibernate.repositories.TeacherRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    private static final Logger logger = LoggerFactory.getLogger(AppConfig.class);

    @Bean
    public CommandLineRunner commandLineRunner(TeacherRepository teacherRepository) {
        return runner -> {
//            addTeacherWithLessons(teacherRepository);
        };
    }

    private static void addTeacherWithLessons(TeacherRepository teacherRepository) {
        Teacher teacher = new Teacher("Steve", "Johnson", "omgosh@gmail.com");
        Teacher teacher1 = new Teacher("John", "Stevens", "omgoshsteve@gmail.com");

        Lesson lesson = new Lesson("ML CodeAcademy");
        Lesson lesson1 = new Lesson("Web Dev");
        Lesson lesson2 = new Lesson("Math");

        teacher.addLesson(lesson);
        teacher.addLesson(lesson1);

        teacher1.addLesson(lesson2);

        teacherRepository.save(teacher);
        teacherRepository.save(teacher1);

        logger.info("DATA IS CREATED!!!");
    }
}