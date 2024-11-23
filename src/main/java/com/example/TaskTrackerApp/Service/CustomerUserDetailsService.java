package com.example.TaskTrackerApp.Service;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import com.example.TaskTrackerApp.Repository.UserRepository;

@Service
public class CustomerUserDetailsService implements UserDetailsService{
    private final UserRepository userRepository; 
    public CustomerUserDetailsService(UserRepository userRepository){ 
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String Username) throws UsernameNotFoundException{ 
        com.example.TaskTrackerApp.Model.User user = userRepository.findByUsername(Username)
        .orElseThrow(() -> new UsernameNotFoundException("User not found" + Username));

        return User.builder()
                    .username(user.getUsername())
                    .password(user.getPassword())
                    .roles(user.getRole())
                    .build(); 
    }

}
