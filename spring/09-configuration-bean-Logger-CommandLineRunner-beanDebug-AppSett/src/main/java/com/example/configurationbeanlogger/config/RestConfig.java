package com.example.configurationbeanlogger.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
@Configuration - this annotation indicates that the class contains Spring bean definitions and
should be processed by the Spring container to generate bean definitions and
service requests for those beans
 */
@Configuration
public class RestConfig {

    /*
    Logger can be used to log messages throughout your application.
     */
    private static final Logger logger = LoggerFactory.getLogger(RestConfig.class);

    /*
    CommandLineRunner interface in Spring Boot provides a way to execute
    code after the application context is loaded.

    @Bean annotation is used to indicate that a method produces a bean to
    be managed by the Spring container.
     */

    @Bean
    CommandLineRunner initData() {
        return args -> {
            // Logging an INFO message
            logger.info("This is an INFO message.");

            // Logging a DEBUG message
            logger.debug("This is a DEBUG message.");

            // Logging a WARN message
            logger.warn("This is a WARN message.");

            // Logging an ERROR message with an exception
            try {
                // Some code that may throw an exception
                throw new RuntimeException("Simulating an error.");
            } catch (Exception e) {
                logger.error("This is an ERROR message with an exception.", e);
            }

            // Logging a TRACE message (less commonly used)
            logger.trace("This is a TRACE message.");
        };
    }

}
