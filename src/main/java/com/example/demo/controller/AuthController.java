package com.example.demo.controller;





import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user) {
        userService.save(user);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @GetMapping("/welcome")
    public String welcomePage() {
        return "welcome";
    }
    
    @GetMapping("/")
    public String index() {
    	return "index";
    }
    
    @GetMapping("/about")
    public String about() {
    	return "about";
    }
    
    @GetMapping("/services")
    public String services() {
    	return "services";
    }
    
    @GetMapping("/trainers")
    public String trainers() {
    	return "trainers";
    }
    
    @GetMapping("/contact")
    public String contact() {
    	return "contact";
    }
    
    @GetMapping("/home")
    public String home() {
    	return "home";
    }
    
}


