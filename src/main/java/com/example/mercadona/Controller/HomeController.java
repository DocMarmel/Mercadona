package com.example.mercadona.Controller;

//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model) {

//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        boolean isAuthenticated = authentication.isAuthenticated();
//
//        if(isAuthenticated) {
//            model.addAttribute("authentication", authentication);
//        }

        return "index";
    }
}
