package com.example.Tutory.teacher;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;


@Configuration
public class TeacherConfig {

    @Bean
    CommandLineRunner commandLineRunner2(TeacherRepository repository2){
        return  args ->{
            Teacher nowy2 = new Teacher(

                    "Jan",
                    "Kowalski",
                    "Kowalski@gmail.com",
                    21

            );
            Teacher nowy3 = new Teacher(

                    "Marek",
                    "Nowak",
                    "Nowak@gmail.com",
                    22

            );
            repository2.saveAll(List.of(nowy2,nowy3));
        };

    }
}
