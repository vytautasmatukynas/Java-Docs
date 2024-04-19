package com.example.basicrestapisampewithsecurity.security.models;



import com.example.basicrestapisampewithsecurity.security.enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;


/**
 * Entity class representing a user in the application.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
public class User implements UserDetails {

    // Primary key ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    // User's first name
    @Column(length = 100, nullable = false)
    private String firstName;

    // User's last name
    @Column(length = 100, nullable = false)
    private String lastName;

    // User's email address (used as the username)
    @Column(length = 100, nullable = false)
    private String email;

    // User's hashed password
    @Column(length = 100, nullable = false)
    private String password;

    // User's role (e.g., USER or ADMIN)
    @Enumerated(EnumType.STRING)
    private Role role;

    /**
     * Returns the authorities granted to the user.
     *
     * @return A list of granted authorities.
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    /**
     * Returns the password used to authenticate the user.
     *
     * @return The user's password.
     */
    @Override
    public String getPassword() {
        return password;
    }

    /**
     * Returns the username used to authenticate the user.
     *
     * @return The user's email address.
     */
    @Override
    public String getUsername() {
        return email;
    }

    /**
     * Indicates whether the user's account has not expired.
     *
     * @return true if the user's account is valid (non-expired), false otherwise.
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * Indicates whether the user is not locked.
     *
     * @return true if the user is not locked, false otherwise.
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * Indicates whether the user's credentials (password) are not expired.
     *
     * @return true if the user's credentials are valid (non-expired), false otherwise.
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * Indicates whether the user is enabled or disabled.
     *
     * @return true if the user is enabled, false otherwise.
     */
    @Override
    public boolean isEnabled() {
        return true;
    }
}
