package com.example.exceptionhandlingsecondsample.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 100)
    private String name;

    @Column(length = 100)
    private String email;

}