package com.example.primaryqualifierannotations.services.implementations;

import com.example.primaryqualifierannotations.services.interfaces.BasicService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class SecondServiceImpl implements BasicService {

    @Override
    public String get() {
        return "hello second";
    }
}
