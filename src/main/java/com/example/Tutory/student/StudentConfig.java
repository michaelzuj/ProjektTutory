package com.example.Tutory.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){

        return  args ->{

            Student nowy1 = new Student(

                    "uname",
                    "Kowalski",
                    "Kowalski@gmail.com",
                    "password",

                    "Student"

                    );

            Student nowy2 = new Student(

                    "Marek",
                    "Nowak",
                    "Nowak@gmail.com",
                    "hasloaa",

                    "Teacher"


                    );




            repository.saveAll(List.of(nowy1,nowy2));
        };

    }
}
