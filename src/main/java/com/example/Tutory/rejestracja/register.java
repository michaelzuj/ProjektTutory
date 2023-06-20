package com.example.Tutory.rejestracja;

import jakarta.persistence.GeneratedValue;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.Collection;

@Controller
@WebServlet("/register")
public class register extends HttpServlet{
    @RequestMapping(path = "/register")
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String imie = request.getParameter("name");
        String nazwisko = request.getParameter("surname");
        String email = request.getParameter("email");
        String haslo = request.getParameter("pass");
        String stanowisko = request.getParameter("stanowisko");


        RequestDispatcher dispatcher = null;
        Connection con = null;


            try {
                Class.forName("org.postgresql.Driver");
                con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/student?useSSL=false", "postgres", "tutory");
                PreparedStatement pst = con.prepareStatement("insert into student(id,email,haslo,imie,nazwisko,stanowisko) values (?,?,?,?,?,?)");
                Statement stmt = con.createStatement();
                String query = "select count(*) from student";
                ResultSet rs = stmt.executeQuery(query);
                //Retrieving the result
                rs.next();
                int count = rs.getInt(1);
                Long id = Long.valueOf(count + 1);
                pst.setLong(1, id);
                pst.setString(2, email);
                pst.setString(3, haslo);
                pst.setString(4, imie);
                pst.setString(5, nazwisko);
                pst.setString(6, stanowisko);
                int rowCount = pst.executeUpdate();
                dispatcher = request.getRequestDispatcher("jsp/rejestracja.jsp");
                if (rowCount > 0) {
                    request.setAttribute("status", "success");

                } else {
                    request.setAttribute("status", "failed");
                }
                dispatcher.forward(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }



    }

}
