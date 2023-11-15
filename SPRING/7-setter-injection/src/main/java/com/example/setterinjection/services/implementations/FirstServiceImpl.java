package com.example.setterinjection.services.implementations;


import com.example.setterinjection.services.interfaces.BasicService;
import org.springframework.stereotype.Service;

/*
@Service - class as a service in the business layer.
 */
@Service
public class FirstServiceImpl implements BasicService {

    @Override
    public String get() {
        return "hello first";
    }
}
