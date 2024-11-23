package com.example.TaskTrackerApp.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.example.TaskTrackerApp.Service.CustomerUserDetailsService;

@Configuration
public class SecurityConfig{
   @Bean
   public BCryptPasswordEncoder passwordEncoder(){
        //lets us save memory by declaring this in 
        return new BCryptPasswordEncoder();
   }
   @Bean
   @SuppressWarnings("removal")
public AuthenticationManager authManager(HttpSecurity http,
   BCryptPasswordEncoder passwordEncoder, 
   CustomerUserDetailsService userService)
        throws Exception { 
            return http.getSharedObject(AuthenticationManagerBuilder.class)
                    .userDetailsService(userService)
                    .passwordEncoder(passwordEncoder)
                    .and()
                    .build();

        }

        @Bean
        public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
            http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth

                .requestMatchers("/api/auth/**").permitAll()
                .anyRequest().authenticated()

                );
                
            return http.build();
        }

   

}
