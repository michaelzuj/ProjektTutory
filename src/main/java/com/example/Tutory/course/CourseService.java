package com.example.Tutory.course;

import com.example.Tutory.student.Student;
import com.example.Tutory.student.StudentRepository;
import jakarta.persistence.Id;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CourseService {

    private StudentRepository studentRepository;
    private CourseRepository courseRepository;
    private Map<Integer, Course> courseMap;
    private int nextCourseId;

    public CourseService(StudentRepository studentRepository) {
        courseMap = new HashMap<>();
        nextCourseId = 1;
        this.studentRepository = studentRepository;
    }

    public List<Course> getAllCourses() {
        return new ArrayList<>(courseMap.values());
    }

    public Course getCourseById(int courseId) {
        return courseMap.get(courseId);
    }

    public void addStudentToCourse(Long student_id, Long course_id){
        Student student = studentRepository.findById(student_id).orElseThrow(() ->
                new IllegalStateException("Podane id: "+ student_id+ " nie istnieje."));
        Course course = courseRepository.findById(course_id).orElseThrow(() ->
                new IllegalStateException("Podane id: "+ course_id+ " nie istnieje."));



        course.getCourseStudents().add(student);
        courseRepository.save(course);


    }

    public Course addCourse(Course course) {
        course.setCourseId(nextCourseId);
        courseMap.put(nextCourseId, course);
        nextCourseId++;
        return course;
    }

    public Course updateCourse(int courseId, Course updatedCourse) {
        if (courseMap.containsKey(courseId)) {
            updatedCourse.setCourseId(courseId);
            courseMap.put(courseId, updatedCourse);
            return updatedCourse;
        }
        return null;
    }

    public boolean deleteCourse(int courseId) {
        if (courseMap.containsKey(courseId)) {
            courseMap.remove(courseId);
            return true;
        }
        return false;
    }
}
