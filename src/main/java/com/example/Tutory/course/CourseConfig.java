package com.example.Tutory.course;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CourseConfig {

    @Bean
    CommandLineRunner commandLineRunner3(CourseRepository repository2) {
        return args -> {
        };

    }
}
