package com.example.demo.Controller;

import com.example.demo.Entity.ToDoEntity;
import com.example.demo.Service.ToDoService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ToDoController {

    @Autowired
    ToDoService toDoService;

    //takes all todos with a todolistentityID, takes every deadline and converts it from DATE to String for the json-object
    @GetMapping("/alltodos/{id}")
    public List<ToDoEntity> getToDos(@PathVariable String id) { 

        List<ToDoEntity> todos = toDoService.getTodosByListId(Long.parseLong(id));

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        
        for (ToDoEntity todo : todos) {

            Date date = todo.getDeadline();
            String formattedDate = formatter.format(date);
            todo.setDate(formattedDate);

        }

        return todos;
    }

    @GetMapping("todo/{id}")
    public ToDoEntity getTodo(@PathVariable String id) { return toDoService.findToDoByID(Long.parseLong(id)); }

    @DeleteMapping("delete/{id}")
    public void deleteTodo(@PathVariable String id){ toDoService.deleteToDo(Long.parseLong(id)); }
    
}
