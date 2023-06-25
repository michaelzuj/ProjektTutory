package com.example.Tutory.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    private final CourseRepository courseRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<Course> getCourses() {
        return courseRepository.findAll();
    }

    public void deleteCourse(Long courseId) {

        boolean exists = courseRepository.existsById(courseId);
        if (!exists) {
            throw new IllegalStateException("" +
                    "To id: " + courseId + " nie istnieje w bazie danych");
        }
        courseRepository.deleteById(courseId);
    }

    public void addCourse(Course course) {
        Optional<Course> courseOptional = courseRepository.findById(course.getCourseId());

        if (courseOptional.isPresent()) {
            throw new IllegalStateException("Kurs już istnieje");

        }

        courseRepository.save(course);

        System.out.println(course);
    }

}
