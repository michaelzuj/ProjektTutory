package com.example.Tutory.course;

import com.example.Tutory.student.Student;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table
public class Course {
    @Id
    private Long courseId;
    private String courseName;

    private String instructor;
    private int numberOfStudents;

    @ManyToMany(mappedBy = "courses")
    private List<Student> students;

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }


    public Course(Long courseId, String courseName, String instructor, int numberOfStudents, List<Student> students) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.instructor = instructor;
        this.numberOfStudents = 0;
        this.students = students;
    }
    public Course(Long courseId, String courseName, String instructor, int numberOfStudents) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.instructor = instructor;
        this.numberOfStudents = 0;
    }

    public Course() {

    }

    public List<Student> getCourseStudents() {
        return students;
    }


    public String getCourseName() {
        return courseName;
    }

    public Long getCourseId() {
        return courseId;
    }

    public String getInstructor() {
        return instructor;
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    public void enrollStudent() {
        numberOfStudents++;
    }

    public void dropStudent() {
        if (numberOfStudents > 0) {
            numberOfStudents--;
        }
    }

    public void displayCourseInfo() {
        System.out.println("Course ID: " + courseId);
        System.out.println("Course Name: " + courseName);
        System.out.println("Instructor: " + instructor);
        System.out.println("Number of Students: " + numberOfStudents);
        System.out.println("Student list: " + students);
    }

    public void setCourseId(int nextCourseId) {
    }
}