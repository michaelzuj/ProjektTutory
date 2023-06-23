package com.example.Tutory.rejestracja;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Controller

@WebServlet("/login")

public class login extends HttpServlet {

    @RequestMapping(path = "/login")
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       // List<String> valuesList = new ArrayList<>();
        String email = request.getParameter("username");
        String haslo = request.getParameter("password");

        HttpSession session = request.getSession();
        RequestDispatcher dispatcher = null;



        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/student?useSSL=false", "postgres", "tutory");
            PreparedStatement pst = con.prepareStatement("select * from student where email = ? and haslo = ?");
            PreparedStatement pst2 = con.prepareStatement("select course_name from course ");

            pst.setString(1, email);
            pst.setString(2, haslo);


            List dataList =new ArrayList();
            ResultSet rs = pst.executeQuery();
            ResultSet rs2 = pst2.executeQuery();
            if (rs.next()) {
                session.setAttribute("name", rs.getString("email"));
                session.setAttribute("name2", rs.getString("stanowisko"));




                Long id_studenta = (Long) session.getAttribute("id");


                dispatcher = request.getRequestDispatcher("jsp/index.jsp");


            } else {
                request.setAttribute("status", "failed");
                dispatcher = request.getRequestDispatcher("jsp/login.jsp");
            }

            while (rs2.next ()){

                dataList.add(rs2.getString("course_name"));
            }

            request.setAttribute("data",dataList);



            dispatcher = request.getRequestDispatcher("jsp/index.jsp");
            dispatcher.forward(request, response);


    } catch (Exception e)
    {
        e.printStackTrace();
    }
    }









}
