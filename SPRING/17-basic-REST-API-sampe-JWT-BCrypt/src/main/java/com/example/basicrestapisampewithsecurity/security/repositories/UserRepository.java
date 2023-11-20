package com.example.basicrestapisampewithsecurity.security.repositories;



import com.example.basicrestapisampewithsecurity.security.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Repository interface for managing User entities.
 */
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * Retrieves a user by their email address.
     *
     * @param email The email address of the user.
     * @return An Optional containing the user if found, or an empty Optional if not found.
     */
    Optional<User> findByEmail(String email);
}
