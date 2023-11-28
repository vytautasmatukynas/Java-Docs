package com.example.securityJDBC.repositories;


import com.example.securityJDBC.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
