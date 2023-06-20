package com.example.demo.Controller;

import com.example.demo.Entity.ToDoEntity;
import com.example.demo.Service.ToDoService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ToDoController {

    @Autowired
    ToDoService toDoService;

    // @PostMapping("/todo/{id}")
    // public ToDoEntity createToDo(@RequestBody ToDoEntity toDo, @PathVariable String id){ return toDoService.saveToDo(toDo, Long.parseLong(id)); }

    @GetMapping("/alltodos/{id}")
    public List<ToDoEntity> getToDos(@PathVariable String id) { return toDoService.getTodosByListId(Long.parseLong(id)); }

    @GetMapping("todo/{id}")
    public ToDoEntity getTodo(@PathVariable String id) { return toDoService.findToDoByID(Long.parseLong(id)); }

}
