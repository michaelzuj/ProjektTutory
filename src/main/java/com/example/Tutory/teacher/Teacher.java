package com.example.Tutory.teacher;

import java.util.List;

import com.example.Tutory.course.Course;

import jakarta.persistence.*;

@Entity
@Table
public class Teacher {
    @Id
    @SequenceGenerator(name = "teacher_sequence", sequenceName = "teacher_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "teacher_sequence")
    private Long id;
    private String imie;
    private String nazwisko;
    private String email;
    @Transient
    private Integer wiek;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "course_teacher", joinColumns = @JoinColumn(name = "id"), inverseJoinColumns = @JoinColumn(name = "courseId"))
    private List<Course> courses;

    public Teacher() {
    }

    public Teacher(Long id, String imie, String nazwisko, String email, Integer wiek) {
        this.id = id;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.email = email;
        this.wiek = wiek;
    }

    public Teacher(String imie, String nazwisko, String email, Integer wiek) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.email = email;
        this.wiek = wiek;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getWiek() {
        return wiek;
    }

    public void setWiek(Integer wiek) {
        this.wiek = wiek;
    }

    @Override
    public String toString() {
        return "Nauczyciel{" +
                "id=" + id +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", email='" + email + '\'' +
                ", wiek=" + wiek +
                '}';
    }
}
