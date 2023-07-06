package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.ToDoEntity;
import com.example.demo.Entity.ToDoListEntity;
import com.example.demo.Service.ToDoListService;

@RestController
public class ToDoListController {

   @Autowired
   ToDoListService toDoListService;

   @GetMapping("/toDoList/{id}")
   public ToDoListEntity getToDoListEntityByID(@PathVariable String id){ return toDoListService.findToDoListByID(Long.parseLong(id)); } 
   
}
