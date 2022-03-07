package com.example.login_application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AppController {

    @Autowired
    private UserRepository userRepo;

    @GetMapping("")
    public String viewHomePage() {
        return "index";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register_form";
    }

    @PostMapping("/process_register")
    public String processRegister(User user) {
        String password = user.getPassword();
        user.setPassword(password);

        userRepo.save(user);

        return "index";
    }

//    @GetMapping("/logged_in")
//    public String showDashboard(User user) {
//        if(String.valueOf( userRepo.findByEmail(user.getEmail()))!=null)
//        return "dashboard";
//        return "error";
//    }


}
