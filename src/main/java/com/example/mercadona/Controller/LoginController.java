package com.example.mercadona.Controller;

import com.example.mercadona.Repository.UserRepository;
import com.example.mercadona.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/login")
    public String FormLogin() {

        return "login";
    }

    @PostMapping("/login")
    public String loginUser(@RequestParam("email") String email,
                                    @RequestParam("password") String password) {

        User user = userRepository.findByEmail(email);

        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        if (user != null && passwordEncoder.matches(password, user.getPassword())) {

            return "redirect:/dashboard";
        } else {

            return "redirect:/login?erreur";
        }
    }
}
