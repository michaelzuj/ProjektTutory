package com.example.Tutory.course;

import com.example.Tutory.student.Student;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table
public class Course {
    @Id
    @SequenceGenerator(
            name = "course_sequence", sequenceName = "course_sequence", allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE, generator = "course_sequence"
    )
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
        this.numberOfStudents = numberOfStudents;
        this.students = students;
    }

    public Course(Long courseId, String courseName, String instructor, int numberOfStudents) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.instructor = instructor;
        this.numberOfStudents = numberOfStudents;
    }

    public Course() {

    }

    public List<Student> getCourseStudents() {
        return students;
    }

    public void setCourseStudents(List<Student> students) {
        this.students = students;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructort(String instructor) {
        this.instructor = instructor;
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    public void setNumberOfStudents(Integer numberOfStudents) {
        this.numberOfStudents = numberOfStudents;
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


    @Override
    public String toString() {
        return "Course{" +
                "id=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", instructor='" + instructor + '\'' +
                ", numberOfStudents='" + numberOfStudents + '\'' +
                ", students=" + students +
                '}';
    }
}

