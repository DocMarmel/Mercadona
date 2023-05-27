package com.example.mercadona.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import com.example.mercadona.User;
import com.example.mercadona.Repository.UserRepository;


@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/profile")
    public String showProfile(Model model, Authentication authentication) {
        // if (authentication != null && authentication.isAuthenticated()) {
        //     String email = authentication.getEmail();
        //     User user = userRepository.findByEmail(email);
        //     model.addAttribute("user", user);
        // }
        return "profile";
    }

    @GetMapping("/profile/edit")
    public String editProfile(Model model) {

        return "editProfile";
    }
}