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
        /*
        The code inside the lambda expression will be executed when the application starts.
         */
        return args -> {
           /*
            This message ("This is SAMPLE MSG..!!") will be printed to
            the log when the application starts
            */
          logger.info("This is SAMPLE MSG..!!");
        };
    }

}
