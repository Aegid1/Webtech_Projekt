package com.example.demo.Controller;

import com.example.demo.Service.UserService;
import com.example.demo.Entity.UserEntity;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {

    @Autowired
    UserService uService;

    @PostMapping("/registration")
    public UserEntity createUser(@RequestBody UserEntity user){ return uService.saveUser(user); }

    @GetMapping("/user/{id}")
    public UserEntity getUser(@PathVariable String id) { return uService.findUserByID(Long.parseLong(id)); }

    @GetMapping("/userEmail/{email}")
    public ResponseEntity<Map<String, Long>> getUserIdByEmail(@PathVariable String email) {  
    
        return ResponseEntity.ok(uService.getUserIdByEmail(email));
    }
}


