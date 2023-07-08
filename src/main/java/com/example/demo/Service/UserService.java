package com.example.demo.Service;

import com.example.demo.Entity.ToDoListEntity;
import com.example.demo.Entity.UserEntity;
import com.example.demo.Repository.ToDoListRepository;
import com.example.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    @Autowired
    UserRepository repo;

    @Autowired
    ToDoListRepository toDoListRepository;

    public UserEntity saveUser(UserEntity user){ return repo.save(user); }

    public void deleteUser(UserEntity user){ repo.delete(user); }
    
    public UserEntity findUserByID(Long id){ return repo.findById(id).orElseThrow(() -> new RuntimeException()); }   
    
    public Long getUserIdByEmail(String email) { return repo.findIdByEmail(email); }
    
    public ToDoListEntity findToDoListIdByUserId(String userId){ return toDoListRepository.findToDoListIdByUserId(Long.parseLong(userId)); }

}
