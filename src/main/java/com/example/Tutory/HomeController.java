package com.example.Tutory;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping(path = "rejestracja")

    public String goToHome() {
        return "rejestracja";
    }

}
