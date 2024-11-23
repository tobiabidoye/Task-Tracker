package com.example.TaskTrackerApp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.TaskTrackerApp.Service.AuthService;

@RestController
public class AuthController {
    @Autowired
    private AuthService authService; 

    @PostMapping("/register")
    String Register(@RequestParam String Username, @RequestParam String Password, @RequestParam String Role){ 
        authService.registerUser((Username), Password, Role);
        return "User Registered Successfully"; 

    }

    @PostMapping("/login")
    public String login(@RequestParam String Username, String Password){ 
        String token = authService.login(Username, Password);

        return "Login Success: " + token; 


    }
}
