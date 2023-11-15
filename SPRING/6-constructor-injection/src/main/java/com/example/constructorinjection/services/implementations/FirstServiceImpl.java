package com.example.constructorinjection.services.implementations;

import com.example.constructorinjection.services.interfaces.FirstService;
import org.springframework.stereotype.Service;

/*
@Service - class as a service in the business layer.
 */
@Service
public class FirstServiceImpl implements FirstService {

    @Override
    public String get() {
        return "hello";
    }
}
