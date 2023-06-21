package com.example.Tutory.course;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CourseService {

    private Map<Integer, Course> courseMap;
    private int nextCourseId;

    public CourseService() {
        courseMap = new HashMap<>();
        nextCourseId = 1;
    }

    public List<Course> getAllCourses() {
        return new ArrayList<>(courseMap.values());
    }

    public Course getCourseById(int courseId) {
        return courseMap.get(courseId);
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
