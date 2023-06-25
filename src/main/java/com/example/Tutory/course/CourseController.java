package com.example.Tutory.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServlet;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController extends HttpServlet {

    @Autowired
    private final CourseService courseService;
    private static final long serialVerionUID = 2L;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public List<Course> getCourses() {
        return courseService.getCourses();
    }

    @PostMapping(consumes = "application/json;charset=UTF-8")
    public void addCourse(@RequestBody Course course) {
        courseService.addCourse(course);
    }

    @DeleteMapping(path = "{courseId}")
    public void deleteCourse(@PathVariable("courseId") Long courseId) {
        courseService.deleteCourse(courseId);
    }

}
