package com.example.demo.Service;

import com.example.demo.Entity.GroupEntity;
import com.example.demo.Entity.ToDoEntity;
import com.example.demo.Entity.UserEntity;
import com.example.demo.Repository.GroupRepository;
import com.example.demo.Repository.UserRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    @Autowired
    UserRepository repo;

    @Autowired
    GroupRepository groupRepository;

    public void updateGroupId(Long groupId, Long userId){
        repo.changeGroupId(groupId, userId);
    }

    public List<ToDoEntity> getTodosByUserId(Long userId){
        
        List<List<Object>> todosSplitted = repo.findTodosByUserId(userId);
        List<ToDoEntity> todos = new ArrayList<>();

        for (List<Object> todoSplitted : todosSplitted) {

            ToDoEntity todo = new ToDoEntity(todoSplitted.get(0), todoSplitted.get(1), todoSplitted.get(2), todoSplitted.get(3));
            todos.add(todo);
        }

        return todos;
    }

    public UserEntity saveUser(UserEntity user){ return repo.save(user); }

    public void deleteUser(UserEntity user){ repo.delete(user); }
    
    public UserEntity findUserByID(Long id){ return repo.findById(id).orElseThrow(() -> new RuntimeException()); }   
    
    public Map<String, Long> getUserIdByEmail(String email) {

        if(email.contains("'")){ email = email.substring(1, email.length() - 1); }

        Map<String, Long> response = new HashMap<>();
        Long userId = repo.findIdByEmail(email); 
        System.out.println(userId);
        response.put("Id", userId);

        return response;

    }
    
    public GroupEntity findToDoListIdByUserId(String userId){ return groupRepository.findGroupByUserId(Long.parseLong(userId)); }
    
    public void updateScore(Long userId){ repo.changeUserScore(userId); }
}
