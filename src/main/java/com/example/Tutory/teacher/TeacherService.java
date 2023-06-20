package com.example.Tutory.teacher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class TeacherService {
    private final TeacherRepository teacherRepository;

    @Autowired
    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public List<Teacher> getTeachers(){
        return teacherRepository.findAll();
    }

    public void addNewTeacher(Teacher teacher) {
        Optional<Teacher> teacherOptional = teacherRepository.findTeacherByEmail(teacher.getEmail());

        if(teacherOptional.isPresent()){
            throw new IllegalStateException("Mail juz uzywany");

        }
        teacherRepository.save(teacher);

        System.out.println(teacher);
    }

    public void deleteTeacher(Long teacherId) {

        boolean exists =teacherRepository.existsById(teacherId);
        if(!exists){
            throw new IllegalStateException("" +
                    "To id: " +teacherId+ " nie istnieje w bazie danych");
        }
        teacherRepository.deleteById(teacherId);
    }



    public void updateTeacher(Long teacherId, String imie, String email) {
        Teacher teacher = teacherRepository.findById(teacherId).orElseThrow(() ->
                new IllegalStateException("Podane id: "+ teacherId+ " nie istnieje."));

        if(imie!= null && imie.length()> 0 && !Objects.equals(teacher.getImie(), imie)){
            teacher.setImie(imie);
        }

        if(email!= null && email.length()> 0 && !Objects.equals(teacher.getEmail(), email)){
            Optional<Teacher> teacherOptional = teacherRepository.findTeacherByEmail(email);
            if(teacherOptional.isPresent()){
                throw new IllegalStateException("Mail zajety");
            }
            teacher.setEmail(email);
        }


    }
}
