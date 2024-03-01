package com.example.exceptionhandling.repositories;


import com.example.exceptionhandling.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByNameAndEmailContainingIgnoreCase(String name, String email);

}
