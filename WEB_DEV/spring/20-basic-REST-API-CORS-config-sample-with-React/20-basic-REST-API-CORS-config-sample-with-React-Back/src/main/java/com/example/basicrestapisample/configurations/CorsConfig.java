package com.example.basicrestapisample.configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Configuration class for Cross-Origin Resource Sharing (CORS) in a Spring application.
 * Enables the server to specify who can access its resources, typically used for allowing
 * requests from a different domain, especially relevant in the context of frontend and
 * backend applications running on separate servers.
 *
 * <p>
 * This class implements the WebMvcConfigurer interface, providing additional configuration
 * for Spring MVC, specifically for CORS.
 * </p>
 */
@Configuration
public class CorsConfig implements WebMvcConfigurer {

    /**
     * Configure Cross-Origin Resource Sharing (CORS) for the Spring application.
     *
     * @param registry The CorsRegistry used to register CORS configuration.
     *                 Allows specifying how CORS should be handled for different endpoints.
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Apply this CORS configuration to all endpoints
                .allowedOrigins("http://localhost:3000") // Allow requests from this origin (your React frontend)
                .allowedMethods("GET", "POST", "PUT", "DELETE") // Allow these HTTP methods
                .allowCredentials(true); // Allow credentials (e.g., cookies) to be sent with the requests
    }
}
