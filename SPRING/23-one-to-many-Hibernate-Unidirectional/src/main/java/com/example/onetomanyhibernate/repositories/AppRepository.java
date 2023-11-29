package com.example.onetomanyhibernate.repositories;

import com.example.onetomanyhibernate.models.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AppRepository extends JpaRepository<Instructor, Long> {

}
