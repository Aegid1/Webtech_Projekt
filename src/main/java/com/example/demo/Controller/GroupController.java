package com.example.demo.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.UserEntity;
import com.example.demo.Service.GroupService;

@RestController
public class GroupController {
    
    @Autowired GroupService groupService;

    @GetMapping("/getGroup/{id}")
    public ResponseEntity<List<Map<String, Object>>> getToDos(@PathVariable String id) { 
        
        List<Map<String, Object>> nameAndScore = new ArrayList<>();

        List<UserEntity> group = groupService.findGroupId(Long.parseLong(id));

        for(UserEntity user : group){ 

            HashMap<String, Object> userData = new HashMap<>();
            userData.put("id", user.getId());
            userData.put("firstname", user.getFirstname());
            userData.put("score", Integer.parseInt(user.getScore()));
            nameAndScore.add(userData);
        }

        return ResponseEntity.ok(nameAndScore);
    }
}
