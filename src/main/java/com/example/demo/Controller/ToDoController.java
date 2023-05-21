package com.example.demo.Controller;

import com.example.demo.Entity.ToDoEntity;
import com.example.demo.Service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ToDoController {

    @Autowired
    ToDoService toDoService;
//hier noch PostMapping ändern
    @PostMapping("/registration")
    public ToDoEntity createToDo(@RequestBody ToDoEntity toDo){

        return toDoService.saveToDo(toDo);
    }

    @GetMapping("/todo/{id}")
    public ToDoEntity getToDo(@PathVariable String id) { return toDoService.findToDoByID(Long.parseLong(id)); }


}
