package com.example.Tutory.course;

import com.example.Tutory.student.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    @Query("SELECT s from Course s where s.courseName = ?1")
    Optional<Course> findCoursesByCourseName(String course_name);
}
