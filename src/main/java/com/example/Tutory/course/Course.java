package com.example.Tutory.course;

import jakarta.persistence.*;

@Entity
@Table
public class Course {
    @Id
    private String courseName;
    private long courseId;
    private String instructor;
    private int numberOfStudents;

    public Course(String courseName, int courseId, String instructor) {
        this.courseName = courseName;
        this.courseId = courseId;
        this.instructor = instructor;
        this.numberOfStudents = 0;
    }

    public Course() {

    }

    public String getCourseName() {
        return courseName;
    }

    public long getCourseId() {
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
        System.out.println("Course Name: " + courseName);
        System.out.println("Course ID: " + courseId);
        System.out.println("Instructor: " + instructor);
        System.out.println("Number of Students: " + numberOfStudents);
    }

    public void setCourseId(long nextCourseId) {
    }
}