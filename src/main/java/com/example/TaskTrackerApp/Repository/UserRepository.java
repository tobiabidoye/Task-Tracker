package com.example.TaskTrackerApp.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.TaskTrackerApp.Model.User;

public interface UserRepository extends JpaRepository<User, Long>{ //key value pair of user and Long in db
    //find a user in the db by username
    Optional <User> findByUsername(String username);
    
}