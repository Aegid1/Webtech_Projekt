package com.example.demo.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.GroupEntity;
import com.example.demo.Service.GroupService;
import com.example.demo.Service.UserService;


@RestController
public class GroupController {
    
    @Autowired 
    GroupService groupService;

    @Autowired 
    UserService userServie;
    
    @GetMapping("/getGroup/{id}")
    public ResponseEntity<List<Map<String, Object>>> getToDos(@PathVariable String id) { 
        
        return ResponseEntity.ok(groupService.getUserAndScores(Long.parseLong(id)));
    }

    @PostMapping("/createGroup/{id}")
    public ResponseEntity<GroupEntity> createGroup(@RequestBody GroupEntity groupData, @PathVariable String id){
       
        return ResponseEntity.ok(groupService.createGroup(groupData, id));

    }
}
