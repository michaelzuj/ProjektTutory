package com.example.Tutory.teacher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/test")
public class TeacherController {
    private final TeacherService teacherService;
    @Autowired
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping
    public List<Teacher> getTeachers()
    {
        return teacherService.getTeachers();
    }

    @PostMapping(consumes = "application/json;charset=UTF-8")
    public void registerNewTeacher(@RequestBody Teacher teacher){
        teacherService.addNewTeacher(teacher);
    }

    @DeleteMapping(path = "{teacherId}")
    public void deleteTeacher(@PathVariable("teacherId") Long teacherId){
        teacherService.deleteTeacher(teacherId);
    }

    @PutMapping(path = "{teacherId}")
    public void updateTeacher(@PathVariable("teacherId") Long teacherId,
                              @RequestParam(required = false) String imie,
                              @RequestParam(required = false) String email)
    {
        teacherService.updateTeacher(teacherId,imie,email);
    }

}
