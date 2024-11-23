package com.example.TaskTrackerApp.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.example.TaskTrackerApp.Model.User;
import com.example.TaskTrackerApp.Repository.UserRepository;
import java.util.Optional;



public class AuthService {

    @Autowired
    private UserRepository userRepository; 

    @Autowired
    private BCryptPasswordEncoder passwordEncoder; 

    public void registerUser(String Username, String Password, String role){ 
        String hashedPassword = passwordEncoder.encode(Password); //hash password to make sure it is encrypted in db
        User user = new User(Username, hashedPassword, role); 
        userRepository.save(user);
    }

    public String login(String username, String password){ 
        Optional <User> userOptional = userRepository.findByUsername(username); 
        if(userOptional.isPresent()){ 
            User user = userOptional.get(); 
            if(passwordEncoder.matches(password, user.getPassword())){ 
                //applies hash to password and compares it to the password in database if the hash patterns match then the password is right
                
                return "Mock Token";
            }
        }
        throw new RuntimeException("Invalid username or password");
    }
}
