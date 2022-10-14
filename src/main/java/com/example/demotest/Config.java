package com.example.demotest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashSet;
import java.util.Set;

@Configuration

public class Config {
    @Bean
    Set<String> ids(){
        return new HashSet<>();
    }
}