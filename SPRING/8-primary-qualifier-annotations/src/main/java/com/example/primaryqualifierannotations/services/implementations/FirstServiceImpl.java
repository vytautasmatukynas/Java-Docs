package com.example.primaryqualifierannotations.services.implementations;


import com.example.primaryqualifierannotations.services.interfaces.BasicService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/*
@Service - class as a service in the business layer.
@Primary - annotation is used to indicate a primary or default bean when
there are multiple beans of the same type within a Spring container.
 */
@Service
@Primary
public class FirstServiceImpl implements BasicService {

    @Override
    public String get() {
        return "hello first";
    }
}
