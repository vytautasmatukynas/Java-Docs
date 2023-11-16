package com.example.security.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Configuration class for security settings, specifically designed for testing and development purposes.
 * Note: This configuration lacks SQL integration, encryption, and other security features and should not
 * be used in a production environment.
 */

/*
 @Configuration - this annotation indicates that the class contains Spring bean definitions and
 should be processed by the Spring container to generate bean definitions and
 service requests for those beans
 */
@Configuration
public class SecurityConfigForTesting {

    /*
     This method is annotated with @Bean, indicating that it produces a bean to be managed by
     the Spring container.
     */

    /*
     {noop} in the password field indicates that the passwords are stored in plain text for simplicity.

     It configures an InMemoryUserDetailsManager, a class provided by the Spring Security framework
     for defining user details in memory. The predefined user details are used for testing and
     development purposes.

     Note: In a production environment, it is crucial to use proper password encoding and hashing
     for enhanced security.
     */
    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        /*
         Define a UserDetails for the user 'john' with the password 'pass123'
         and the role 'EMPLOYEE'
         */
        UserDetails john = User.builder()
                .username("john")
                .password("{noop}pass123")
                .roles("EMPLOYEE")
                .build();

        /*
         Define a UserDetails for the user 'steve' with the password 'pass123'
         and roles 'EMPLOYEE' and 'MANAGER'
         */
        UserDetails steve = User.builder()
                .username("steve")
                .password("{noop}pass123")
                .roles("EMPLOYEE", "MANAGER")
                .build();

        /*
         Define a UserDetails for the user 'bubbles' with the password 'pass123'
         and roles 'EMPLOYEE', 'MANAGER', and 'ADMIN'
         */
        UserDetails bubbles = User.builder()
                .username("bubbles")
                .password("{noop}pass123")
                .roles("EMPLOYEE", "MANAGER", "ADMIN")
                .build();

        // Create an InMemoryUserDetailsManager and pass the defined UserDetails objects (john, steve, bubbles)
        return new InMemoryUserDetailsManager(john, steve, bubbles);
    }

    // Define a SecurityFilterChain bean to configure security for specific HTTP requests
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        // Configure authorization for specific HTTP methods and paths
        http.authorizeHttpRequests(config ->
                // Allow GET requests to "/api/employees" for users with role "EMPLOYEE"
                config.requestMatchers(HttpMethod.GET, "/api/employees").hasRole("EMPLOYEE")
                        /*
                         Allow GET requests to "/api/employees/**" for users with role "EMPLOYEE".
                         "**" wildcard matches any path starting with "/api/employees/" and followed
                         by any number of path segments.
                         */
                        .requestMatchers(HttpMethod.GET, "/api/employees/**").hasRole("EMPLOYEE")
                        // Allow POST requests to "/api/employees" for users with role "MANAGER"
                        .requestMatchers(HttpMethod.POST, "/api/employees").hasRole("MANAGER")
                        // Allow PUT requests to "/api/employees" for users with role "MANAGER"
                        .requestMatchers(HttpMethod.PUT, "/api/employees").hasRole("MANAGER")
                        // Allow DELETE requests to "/api/employees/**" for users with role "ADMIN"
                        .requestMatchers(HttpMethod.DELETE, "/api/employees/**").hasRole("ADMIN")
        );

        // Use HTTP Basic authentication for securing the application
        http.httpBasic(Customizer.withDefaults());

        /*
         Disable Cross-Site Request Forgery (CSRF) protection.
         This is generally not required for stateless REST APIs using POST, PUT, DELETE, and PATCH.
         */
        http.csrf(csrf -> csrf.disable());

        // Build and return the configured HttpSecurity object
        return http.build();
    }

}
