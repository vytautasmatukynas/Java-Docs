package com.example.basicrestapisampewithsecurity.security.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data Transfer Object (DTO) for registration requests.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationRequestDTO {

    // The first name of the user
    @NotBlank(message = "First name cannot be blank")
    private String firstName;

    // The last name of the user
    @NotBlank(message = "Last name cannot be blank")
    private String lastName;

    // The email address for registration
    @NotBlank(message = "Email cannot be blank")
    @Email(message = "Invalid email format")
    private String email;

    // The password for registration
    @NotBlank(message = "Password cannot be blank")
    private String password;
}
