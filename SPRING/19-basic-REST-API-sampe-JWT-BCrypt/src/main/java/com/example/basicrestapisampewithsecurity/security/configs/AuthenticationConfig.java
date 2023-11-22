package com.example.basicrestapisampewithsecurity.security.configs;

import com.example.basicrestapisampewithsecurity.security.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Configuration class responsible for setting up authentication-related components
 * in the Spring application, including a custom UserDetailsService,
 * AuthenticationProvider using DaoAuthenticationProvider, AuthenticationManager,
 * and a BCryptPasswordEncoder for password hashing.
 */
@Configuration
@RequiredArgsConstructor
public class AuthenticationConfig {

    // Injected UserRepository for accessing user details
    private final UserRepository userRepository;

    /**
     * Defines a custom UserDetailsService.
     *
     * @return The custom UserDetailsService implementation.
     */
    @Bean
    public UserDetailsService userDetailsService() {
        return username -> userRepository
                .findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found."));
    }

    /**
     * Defines a custom AuthenticationProvider using DaoAuthenticationProvider.
     *
     * @return The configured AuthenticationProvider.
     */
    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();

        // Set the custom UserDetailsService
        authenticationProvider.setUserDetailsService(userDetailsService());

        // Set the password encoder (BCryptPasswordEncoder)
        authenticationProvider.setPasswordEncoder(passwordEncoder());

        // Return the configured AuthenticationProvider
        return authenticationProvider;
    }

    /**
     * Defines an AuthenticationManager.
     *
     * @param authenticationConfiguration The authentication configuration.
     * @return The AuthenticationManager.
     * @throws Exception If an error occurs while getting the AuthenticationManager.
     */
    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    /**
     * Defines a BCryptPasswordEncoder for password hashing.
     *
     * @return The BCryptPasswordEncoder.
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
