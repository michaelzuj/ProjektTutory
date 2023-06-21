package com.example.Tutory.course;

import com.example.Tutory.student.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class CourseConfig {

    @Bean
    CommandLineRunner commandLineRunner3(CourseRepository repository2) {
        return args -> {
            Course nowy1 = new Course(
                    2L,
                    "Systemy mobilne",
                    "Kowalski@gmail.com",
                    2


                    );
            repository2.saveAll(List.of(nowy1));



        };

    }
}
