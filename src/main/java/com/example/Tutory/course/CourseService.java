package com.example.Tutory.course;

import com.example.Tutory.student.Student;
import com.example.Tutory.student.StudentRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.Id;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CourseService {

    @Autowired
    private StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    private Long nextCourseId;

    @Autowired
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }



    public List<Course> getAllCourses() { return courseRepository.findAll ();
    }



    public void addStudentToCourse(Long course_id , Long student_id){

        Student student = studentRepository.findById(student_id).orElseThrow(() ->
                new EntityNotFoundException("Podane id: "+ student_id+ " nie istnieje."));
        Course course = courseRepository.findById(course_id).orElseThrow(() ->
                new EntityNotFoundException("Podane id: "+ course_id+ " nie istnieje."));



        course.getCourseStudents().add(student);
        student.getCourses().add(course);
        courseRepository.save(course);


    }

    public void addCourse(Course course) {
        courseRepository.save(course);

        System.out.println(course);
    }

    public Long getCourseIdByName(String courseName) {


        for (Course course : getAllCourses()) {
            if (course.getCourseName().equals(courseName)) {
                return course.getCourseId();
            }
        }
        return -1L;
    }




    @Transactional
    public void updateCourse(Long courseId, String imie ){
        Course course = courseRepository.findById(courseId).orElseThrow(() ->
                new IllegalStateException("Podane id: "+ courseId+ " nie istnieje."));

        if(imie!= null && imie.length()> 0 && !Objects.equals(course.getCourseName(), imie)){
            course.setCourseName(imie);
        }



    }


    public void deleteCourse(Long courseId) {

        boolean exists =courseRepository.existsById(courseId);
        if(!exists){
            throw new IllegalStateException("" +
                    "To id: " +courseId+ " nie istnieje w bazie danych");
        }
        courseRepository.deleteById(courseId);
    }



}
