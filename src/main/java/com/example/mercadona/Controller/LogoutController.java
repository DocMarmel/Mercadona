package com.example.mercadona.Controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LogoutController {

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {

    return "redirect:/";
    }
}
