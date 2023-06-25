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
                    1L,
                    "Systemy mobilne",
                    "Kowalski@gmail.com",
                    2


                    );
            Course nowy2 = new Course(
                    2L,
                    "Electronic economy",
                    "Kowalski@gmail.com",
                    2


            );
            Course nowy3 = new Course(
                    3L,
                    "Matematyka",
                    "Kowalski@gmail.com",
                    2


            );

            repository2.saveAll(List.of(nowy1,nowy2,nowy3));



        };

    }
}
