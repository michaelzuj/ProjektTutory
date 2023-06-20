package com.example.Tutory.rejestracja;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Controller
@WebServlet("/logout")
public class logout extends HttpServlet {
    @RequestMapping(path = "/logout")
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {{
        HttpSession session = request.getSession();
        session.invalidate();
        response.sendRedirect("jsp/login.jsp");


    }}
}
