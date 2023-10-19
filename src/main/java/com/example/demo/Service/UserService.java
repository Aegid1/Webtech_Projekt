package com.example.demo.Service;

import com.example.demo.Entity.GroupEntity;
import com.example.demo.Entity.UserEntity;
import com.example.demo.Repository.GroupRepository;
import com.example.demo.Repository.UserRepository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    @Autowired
    UserRepository repo;

    @Autowired
    GroupRepository groupRepository;

    public UserEntity saveUser(UserEntity user){ return repo.save(user); }

    public void deleteUser(UserEntity user){ repo.delete(user); }
    
    public UserEntity findUserByID(Long id){ return repo.findById(id).orElseThrow(() -> new RuntimeException()); }   
    
    public Map<String, Long> getUserIdByEmail(String email) {

        if(email.contains("'")){ email = email.substring(1, email.length() - 1); }

        Map<String, Long> response = new HashMap<>();
        Long userId = repo.findIdByEmail(email); 
        response.put("Id", userId);

        return response;

    }
    
    public GroupEntity findToDoListIdByUserId(String userId){ return groupRepository.findGroupByUserId(Long.parseLong(userId)); }
    
    public void updateScore(Long userId){ repo.changeUserScore(userId); }
}
