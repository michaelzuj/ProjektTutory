package com.example.Tutory;

import com.example.Tutory.student.Student;
import com.example.Tutory.student.StudentRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
public class TutoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(TutoryApplication.class, args);



	}

//	@GetMapping(path = "rejestracja")
//	public String hello(){
//		return StudentRepository.class.getName();
//	}


}
