package com.example.Tutory.teacher;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    @Query("SELECT s from Teacher s where s.email = ?1")
    Optional<Teacher> findTeacherByEmail(String email);

}
