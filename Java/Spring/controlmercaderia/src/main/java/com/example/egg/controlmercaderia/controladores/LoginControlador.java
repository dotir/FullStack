package com.example.egg.controlmercaderia.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginControlador {

    @GetMapping("/login")
    public String login() {
        return "login"; // Change to your login view name
    }
}
