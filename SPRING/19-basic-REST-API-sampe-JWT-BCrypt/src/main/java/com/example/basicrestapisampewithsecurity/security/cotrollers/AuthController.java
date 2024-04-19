package com.example.basicrestapisampewithsecurity.security.cotrollers;


import com.example.basicrestapisampewithsecurity.security.dtos.AuthenticationRequestDTO;
import com.example.basicrestapisampewithsecurity.security.dtos.AuthenticationResponseDTO;
import com.example.basicrestapisampewithsecurity.security.dtos.RegistrationRequestDTO;
import com.example.basicrestapisampewithsecurity.security.models.User;
import com.example.basicrestapisampewithsecurity.security.services.AuthService;
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
     * @return User details.
     */
    @PostMapping("register")
    public ResponseEntity<User> register(
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
