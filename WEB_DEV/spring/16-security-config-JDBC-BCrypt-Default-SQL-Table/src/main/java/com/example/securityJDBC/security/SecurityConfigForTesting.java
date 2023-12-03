package com.example.securityJDBC.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

/*
 @Configuration - this annotation indicates that the class contains Spring bean definitions and
 should be processed by the Spring container to generate bean definitions and
 service requests for those beans
 */
@Configuration
@EnableWebSecurity
public class SecurityConfigForTesting {

    /*
     * This method is annotated with @Bean, indicating that it produces a bean to be managed by
     * the Spring container.
     */

    /*
     * It configures a JdbcUserDetailsManager backed by the provided DataSource. This class is responsible
     * for managing user details in the database. In this example, predefined user details are used for
     * testing and development purposes. Note: In a production environment, it is crucial to use proper
     * password encoding and hashing for enhanced security.
     */
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {
        return new JdbcUserDetailsManager(dataSource);
    }

    // Define a SecurityFilterChain bean to configure security for specific HTTP requests
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        // Configure authorization for specific HTTP methods and paths
        http.authorizeHttpRequests(config ->
                // Allow GET requests to "/api/employees" and "/api/employees/**" for users with role "EMPLOYEE"
                config.requestMatchers(HttpMethod.GET, "/api/employees/**").hasRole("EMPLOYEE")
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
         * Disable Cross-Site Request Forgery (CSRF) protection.
         * This is generally not required for stateless REST APIs using POST, PUT, DELETE, and PATCH.
         * "csrf -> csrf.disable()" = "AbstractHttpConfigurer::disable"
         */
        http.csrf(AbstractHttpConfigurer::disable);

        // Build and return the configured HttpSecurity object
        return http.build();
    }

}
