package com.example.securityconfigurationjwtbcrypt.security.cotrollers;

import com.example.securityconfigurationjwtbcrypt.security.dtos.AuthenticationRequestDTO;
import com.example.securityconfigurationjwtbcrypt.security.dtos.AuthenticationResponseDTO;
import com.example.securityconfigurationjwtbcrypt.security.dtos.RegistrationRequestDTO;
import com.example.securityconfigurationjwtbcrypt.security.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller class handling authentication-related endpoints.
 */
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    // Injected AuthService for handling authentication logic
    private final AuthService authService;

    /**
     * Handles the registration endpoint.
     *
     * @param request The registration request data.
     * @return ResponseEntity containing the authentication response DTO.
     */
    @PostMapping("register")
    public ResponseEntity<AuthenticationResponseDTO> register(
            @RequestBody RegistrationRequestDTO request
    ) {
        return ResponseEntity.ok(authService.register(request));
    }

    /**
     * Handles the authentication endpoint.
     *
     * @param request The authentication request data.
     * @return ResponseEntity containing the authentication response DTO.
     */
    @PostMapping("authenticate")
    public ResponseEntity<AuthenticationResponseDTO> authenticate(
            @RequestBody AuthenticationRequestDTO request
    ) {
        return ResponseEntity.ok(authService.authenticate(request));
    }
}
