package com.example.onetoonehibernate.configs;

import com.example.onetoonehibernate.models.Instructor;
import com.example.onetoonehibernate.models.InstructorDetail;
import com.example.onetoonehibernate.services.AppService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    private static final Logger logger = LoggerFactory.getLogger(AppConfig.class);

    /**
     * Configures a CommandLineRunner bean to execute a specific action when the application starts.
     *
     * @param appService The service used for interacting with the application's business logic.
     * @return A CommandLineRunner bean that runs the specified action.
     */
    @Bean
    public CommandLineRunner commandLineRunner(AppService appService) {
        return runner -> {
            // Calls the method to create and save an instructor using the provided AppService.
//            createInstructor(appService);

            logger.info("DATA IS CREATED!!!");
        };
    }

    /**
     * Creates an Instructor and associated InstructorDetail, then saves them using the provided AppService.
     *
     * @param appService The service used for interacting with the application's business logic.
     */
    private void createInstructor(AppService appService) {
        // Creates a new Instructor with the given details.
        Instructor instructor = new Instructor("Steve", "Johnson", "omgosh@gmail.com");

        // Creates a new InstructorDetail with some link and YouTube channel information.
        InstructorDetail instructorDetail = new InstructorDetail("somelink123.com", "worker");

        // Associates the InstructorDetail with the Instructor.
        instructor.setInstructorDetail(instructorDetail);

        // Save instructor
        // This also saves the details object because of CascadeType.ALL.
        // The AppService's save method likely uses a JpaRepository to persist the entities.
        appService.save(instructor);
    }
}