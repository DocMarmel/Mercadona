package com.example.mercadona.Controller;

import com.example.mercadona.Repository.UserRepository;
import com.example.mercadona.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegisterController {

    @Autowired
    private UserRepository userRepository;
    private BCryptPasswordEncoder passwordEncoder;

    public RegisterController() {
        passwordEncoder = new BCryptPasswordEncoder();
    }

    @GetMapping("/register")
    public String createUserForm() {

        return "register";
    }

    @PostMapping("/register")
    public String createUser(@RequestParam("lastName") String lastName,
                               @RequestParam("firstName") String firstName,
                               @RequestParam("email") String email,
                               @RequestParam("password") String password) {

        String encodedPassword = passwordEncoder.encode(password);


        User user = new User();
        user.setLastName(lastName);
        user.setFirstName(firstName);
        user.setEmail(email);
        user.setPassword(encodedPassword);

        userRepository.save(user);

        return "redirect:/dashboard";
    }
}
