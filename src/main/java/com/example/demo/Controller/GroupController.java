package com.example.demo.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.GroupEntity;
import com.example.demo.Entity.ToDoEntity;
import com.example.demo.Entity.UserEntity;
import com.example.demo.Repository.GroupRepository;
import com.example.demo.Service.GroupService;

@RestController
public class GroupController {
    
    @Autowired GroupService groupService;

    @GetMapping("/getGroup/{id}")
    public List<UserEntity> getToDos(@PathVariable String id) { 
        
        List<UserEntity> group = groupService.findGroupId(Long.parseLong(id));
        return group;
    }
}
