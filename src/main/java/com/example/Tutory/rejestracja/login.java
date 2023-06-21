package com.example.Tutory.rejestracja;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.sql.*;
@Controller
@WebServlet("/login")
public class login extends HttpServlet {

    @RequestMapping(path = "/login")
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
    String email = request.getParameter("username");
    String haslo = request.getParameter("password");

    HttpSession session = request.getSession();
        RequestDispatcher dispatcher = null;



        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/student?useSSL=false","postgres","tutory");
            PreparedStatement pst = con.prepareStatement("select * from student where email = ? and haslo = ?");
            pst.setString(1,email);
            pst.setString(2,haslo);

            ResultSet rs= pst.executeQuery();
            if(rs.next()){
                session.setAttribute("name", rs.getString("email"));
                session.setAttribute("name2", rs.getString("stanowisko"));
                dispatcher = request.getRequestDispatcher("jsp/index.jsp");

            }else {
                request.setAttribute("status","failed");
                dispatcher = request.getRequestDispatcher("jsp/login.jsp");
            }
            dispatcher.forward(request,response);

        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }


}
