package com.example.Tutory.course;

import com.example.Tutory.student.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class CourseConfig {

    @Bean
    CommandLineRunner commandLineRunner3(CourseRepository courseRepository) {
        return args -> {
            Course nowykurs = new Course(
                    1L,
                    "Fizyka",
                    "Kowalski@gmail.com",
                    2


                    );
            Course nowykurs2 = new Course(
                    2L,
                    "Economy",
                    "Kowalski@gmail.com",
                    2


            );
            Course nowykurs3 = new Course(
                    3L,
                    "Matematyka",
                    "Kowalski@gmail.com",
                    2


            );

            courseRepository.saveAll(List.of(nowykurs,nowykurs2,nowykurs3));



        };

    }
}
