package com.example.TaskTrackerApp.Model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 
    private String username; 
    private String password;
    private String role;
    public User(){ 
    }

    public User(String username, String password, String role){ 
        this.username = username; 
        this.password = password; 
        this.role = role;
    } 

    public String getUsername(){ 
        return username;
    }
    
    public String getPassword(){ 
        return password; 
    }
    
    public String getRole(){ 
        return role;
    }

    public Long getId(){ 
        return id;
    }

    public void setUsername(String username){ 
        this.username = username;
    }

    public void setPassword(String password){ 
        this.password = password;
    }

    public void setRole(String role){ 
        this.role = role;
    }

    public void setId(Long id){ 
        this.id = id;
    }

    @Override
    public String toString(){ 
        //to return user in a json like format
        return "User{" +
                "id=" + id +
                ", username='" + username +'\'' +
                ", role='" + role + '\''+
                '}';
    }

    @Override
    public boolean equals(Object o){ 
        if(this == o) return true; 
        if(o == null || getClass() != o.getClass()) return false;
        User user = (User) o; 
        return id != null && id.equals(user.id);
    }

    @Override
    public int hashCode(){ 
        return getClass().hashCode();
    }

}
