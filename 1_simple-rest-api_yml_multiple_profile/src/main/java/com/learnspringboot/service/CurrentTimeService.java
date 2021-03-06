package com.learnspringboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CurrentTimeService {

    @Autowired
    Environment environment; // it is used to read the field from .properties or .yml file..

    public String getCurrentDateTime() {
        LocalDateTime localDateTime = LocalDateTime.now();
        return environment.getProperty("message").concat("\n").concat(localDateTime.toString());
    }
}
