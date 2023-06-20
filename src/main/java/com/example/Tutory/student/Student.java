package com.example.Tutory.student;

import jakarta.persistence.*;


@Entity
@Table
public class Student {
    @Id
    @SequenceGenerator(
            name="student_sequence", sequenceName = "student_sequence", allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE, generator = "student_sequence"
    )
    private Long id;
    private String imie;
    private String nazwisko;
    private String email;
    private String haslo;

    private String stanowisko;

    public Student() {
    }

    public Student(Long id, String imie, String nazwisko, String email, String haslo, String stanowisko) {
        this.id = id;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.email = email;
        this.haslo = haslo;
        this.stanowisko = stanowisko;
    }

    public Student(String imie, String nazwisko, String email, String haslo, String stanowisko) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.email = email;
        this.haslo = haslo;
        this.stanowisko = stanowisko;
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

    public String getHaslo() {
        return haslo;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }
    public String getStanowisko() {
        return haslo;
    }

    public void setStanowisko(String haslo) {
        this.haslo = haslo;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", email='" + email + '\'' +
                ", haslo=" + haslo +
                ", stanowisko=" + stanowisko +
                '}';
    }
}
