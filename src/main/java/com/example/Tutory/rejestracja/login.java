package com.example.Tutory.rejestracja;

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

@WebServlet("/login")

public class login extends HttpServlet {

    private final CourseService courseService;

    public login(CourseService courseService) {
        this.courseService = courseService;
    }


    @RequestMapping(path = "/login")
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email = request.getParameter("username");
        String haslo = request.getParameter("password");
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



//        CourseService courseService = new CourseService();

//        courseService.addStudentToCourse(idStudenta,idStudenta);


        HttpSession session = request.getSession();
        RequestDispatcher dispatcher = null;



        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/student?useSSL=false", "postgres", "tutory");
            PreparedStatement pst = con.prepareStatement("select * from student where email = ? and haslo = ?");
            PreparedStatement pst2 = con.prepareStatement("select course_name, course_id from course");


            pst.setString(1, email);
            pst.setString(2, haslo);


            List dataList =new ArrayList();



            ResultSet rs = pst.executeQuery();
            ResultSet rs2 = pst2.executeQuery();
            if (rs.next()) {
                session.setAttribute("name", rs.getString("email"));
                session.setAttribute("name2", rs.getString("stanowisko"));
                session.setAttribute("idStudenta2", rs.getLong("id"));



                dispatcher = request.getRequestDispatcher("jsp/index.jsp");


            } else {
                request.setAttribute("status", "failed");
                dispatcher = request.getRequestDispatcher("jsp/login.jsp");
            }

            while (rs2.next ()){

                dataList.add(rs2.getString("course_name"));

               // idKursu = courseService.getCourseIdByName((String) session.getAttribute("textvalue"));
               // session.setAttribute("idKursu", idKursu);

            }



          //  courseService.addStudentToCourse(idStudenta,idKursu2);

            request.setAttribute("data",dataList);




            dispatcher = request.getRequestDispatcher("jsp/index.jsp");
            dispatcher.forward(request, response);





    } catch (Exception e)
    {
        e.printStackTrace();
    }
    }










}
