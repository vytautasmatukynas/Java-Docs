package com.example.securityconfigurationjwtbcrypt.security.services;

import com.example.securityconfigurationjwtbcrypt.security.dtos.AuthenticationRequestDTO;
import com.example.securityconfigurationjwtbcrypt.security.dtos.AuthenticationResponseDTO;
import com.example.securityconfigurationjwtbcrypt.security.dtos.RegistrationRequestDTO;
import com.example.securityconfigurationjwtbcrypt.security.enums.Role;
import com.example.securityconfigurationjwtbcrypt.security.models.User;
import com.example.securityconfigurationjwtbcrypt.security.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Service class for user authentication and registration.
 */
@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    /**
     * Registers a new user based on the provided registration request.
     *
     * @param request The registration request.
     * @return An authentication response containing a JWT token.
     */
    public User register(RegistrationRequestDTO request) {
        // Create a new user entity
        User user = User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();

        // Save the user to the database
        userRepository.save(user);

        return user;
    }

    /**
     * Authenticates a user based on the provided authentication request.
     *
     * @param request The authentication request.
     * @return An authentication response containing a JWT token.
     * @throws BadCredentialsException If authentication fails.
     */
    public AuthenticationResponseDTO authenticate(AuthenticationRequestDTO request) {
        try {
            // Perform authentication using the provided credentials
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getEmail(),
                            request.getPassword()
                    )
            );
        } catch (AuthenticationException e) {
            // Authentication failed
            throw new BadCredentialsException("Invalid email or password");
        }

        // Retrieve the user from the database based on the provided email
        User user = userRepository
                .findByEmail(request.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        // Generate a JWT token for the authenticated user
        String jwtToken = jwtService.generateToken(user);

        // Return an authentication response with the generated token
        return AuthenticationResponseDTO.builder()
                .token(jwtToken)
                .build();
    }
}
