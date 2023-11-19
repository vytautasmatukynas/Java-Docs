package com.example.securityconfigurationjwtbcrypt.security.configs;

import jakarta.servlet.Filter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * Configuration class responsible for setting up authentication-related components
 * in the Spring application, including a custom UserDetailsService,
 * AuthenticationProvider using DaoAuthenticationProvider, AuthenticationManager,
 * and a BCryptPasswordEncoder for password hashing.
 */
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final Filter jwtAuthFilter;
    private final AuthenticationProvider authenticationProvider;

    /**
     * Configures the security filter chain for the application.
     *
     * @param httpSecurity The HttpSecurity object to configure.
     * @return The configured SecurityFilterChain.
     * @throws Exception If an error occurs during configuration.
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                // Disable CSRF protection
                .csrf(AbstractHttpConfigurer::disable)
                // Configure authorization rules for specific endpoints
                .authorizeHttpRequests(auth -> auth
                        // Allow public access to the registration endpoint
                        .requestMatchers("/api/auth/**").permitAll()

//                        SAMPLE of defining end-points for ROLES"
//                        // Require ADMIN role for endpoints under /api/
//                        .requestMatchers("/api/**").hasRole("ADMIN")
//                        // Require USER role for endpoints under /api/demo/
//                        .requestMatchers("/api/demo/**").hasRole("USER")
//                        // endpoints under /api/demo/ and can be used with GET and you need TOKEN for
//                        // other request
//                        .requestMatchers(HttpMethod.GET, "/api/books/**").permitAll()
//                        If jwt is used, and end-point isn't defined here, then that endpoint can be
//                        used just with generated TOKEN.

                        // Require authentication for any other request
                        .anyRequest()
                        .authenticated())

                // Configure session management to be stateless (no sessions)
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                // Set the custom AuthenticationProvider
                .authenticationProvider(authenticationProvider)
                // Add the JWT authentication filter before the standard UsernamePasswordAuthenticationFilter
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

        // Build and return the configured HttpSecurity
        return httpSecurity.build();
    }
}
