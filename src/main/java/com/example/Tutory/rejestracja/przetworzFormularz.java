package com.example.Tutory.rejestracja;

import com.example.Tutory.course.CourseService;
import com.example.Tutory.student.StudentRepository;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

//@Controller
//public class przetworzFormularz {
//@PostMapping("/przetworzFormularz")
//    public String przetworzFormularz(String wybranyKurs){
//        System.out.println("Wybrany kurs " + wybranyKurs);
//    String path = "/przetworzFormularz";
//    return path;
//
//    }
//
//}





        import com.example.Tutory.course.CourseService;
        import jakarta.servlet.RequestDispatcher;
        import jakarta.servlet.ServletException;
        import jakarta.servlet.annotation.WebServlet;
        import jakarta.servlet.http.HttpServlet;
        import jakarta.servlet.http.HttpServletRequest;
        import jakarta.servlet.http.HttpServletResponse;
        import jakarta.servlet.http.HttpSession;
        import org.springframework.stereotype.Controller;
        import org.springframework.web.bind.annotation.PostMapping;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RequestParam;
        import org.springframework.web.bind.annotation.RestController;

        import java.io.IOException;
        import java.sql.*;
        import java.util.ArrayList;
        import java.util.List;

@Controller
@Service
@WebServlet("/przetworzFormularz")

public class przetworzFormularz extends HttpServlet {

    private final CourseService courseService;

    public przetworzFormularz(CourseService courseService) {
        this.courseService = courseService;
    }

    @Autowired
    private StudentRepository studentRepository;


    @RequestMapping(path = "/przetworzFormularz")
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String nazwaKursu = request.getParameter("textvalue");

        Long parsedValue;
        if (nazwaKursu != null) {
            try {
                parsedValue = Long.parseLong(nazwaKursu);

            } catch (NumberFormatException e) {

            }
        } else {

        }

        String idStudentaParam = request.getParameter("idStudenta2");
        Long id_studenta = null;

        if (idStudentaParam != null) {
            try {
                id_studenta = Long.parseLong(idStudentaParam);
            } catch (NumberFormatException e) {
            }
        } else {

        }




        Long idKursu = courseService.getCourseIdByName(nazwaKursu);
        courseService.addStudentToCourse(idKursu, id_studenta);



        System.out.println("Id studenta: " + id_studenta);
        System.out.println("idKursu  " + idKursu);

        HttpSession session = request.getSession();
        RequestDispatcher dispatcher = null;

//        HttpSession session2 = request.getSession();
//        RequestDispatcher dispatcher2 = null;

        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/student?useSSL=false", "postgres", "tutory");
            PreparedStatement pst = con.prepareStatement("select * from student");
            PreparedStatement pst2 = con.prepareStatement("select * from course where course_id=?");

            pst2.setLong(1,idKursu);



            List<Long> dataList = new ArrayList<>();

            ResultSet rs = pst.executeQuery();
            ResultSet rs2 = pst2.executeQuery();

            if (rs.next()) {
                session.setAttribute("name", rs.getString("email"));
                session.setAttribute("name2", rs.getString("stanowisko"));


             dispatcher = request.getRequestDispatcher("jsp/przetworzFormularz.jsp");


            } else {
           }


            if (rs2.next()) {
                session.setAttribute("course_id", rs2.getLong("course_id"));
                session.setAttribute("number_of_students", rs2.getInt("number_of_students"));
                session.setAttribute("course_name", rs2.getString("course_name"));
                session.setAttribute("instructor", rs2.getString("instructor"));

                dispatcher = request.getRequestDispatcher("jsp/przetworzFormularz.jsp");


            } else {
            }












            dispatcher.forward(request, response);





        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }










}
