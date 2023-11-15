package com.example.exceptionhandlingsecondsample.repositories;


import com.example.exceptionhandlingsecondsample.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByNameAndEmailContainingIgnoreCase(String name, String email);

}
