package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    
    @Autowired UserService uService;

    @PostMapping("/save/user")
    public User createUser(String firstname, String lastname, String email, String password){
        
        User user = new User();

        user.setFirstname(firstname);
        user.setLastname(lastname);
        user.setEmail(email);
        user.setPassword(password);

        return uService.saveUser(user);
    }

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable String id) { return uService.findUserByID(Long.parseLong(id)); }

    
}
