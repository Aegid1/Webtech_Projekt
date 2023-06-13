package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.Entity.ToDoListEntity;
import com.example.demo.Service.ToDoListService;
import com.example.demo.Service.ToDoService;

public class ToDoListController {

   @Autowired
   ToDoListService toDoListService;

   @GetMapping("/todoList/{id}")
   public ToDoListEntity getToDoListEntityByID(@PathVariable String id){ return toDoListService.findToDoListByID(Long.parseLong(id)); } 
   
}
