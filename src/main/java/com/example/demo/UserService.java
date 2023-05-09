package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    @Autowired
    UserRepository repo;

    public UserEntity saveUser(UserEntity user){ return repo.save(user); }

    public void deleteUser(UserEntity user){ repo.delete(user); }

    public UserEntity findUserByID(Long id){ return repo.findById(id).orElseThrow(() -> new RuntimeException()); }   
    
    
}
