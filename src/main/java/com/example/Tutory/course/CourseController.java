package com.example.Tutory.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.Tutory.student.Student;
import com.example.Tutory.student.StudentService;

import jakarta.servlet.http.HttpServlet;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController extends HttpServlet {

    @Autowired
    private final CourseService courseService;
    private static final long serialVerionUID = 1L;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public List<Course> getCourses() {
        return courseService.getCourses();
    }

    @PostMapping(consumes = "application/json;charset=UTF-8")
    public void registerNewStudent(@RequestBody Course course) {
        courseService.addCourse(course);
    }

    @DeleteMapping(path = "{courseId}")
    public void deleteCourse(@PathVariable("courseId") Long courseId) {
        courseService.deleteCourse(courseId);
    }

}
