package com.example.demo.Controller;

import com.example.demo.Entity.ToDoEntity;
import com.example.demo.Entity.ToDoListEntity;
import com.example.demo.Service.ToDoListService;
import com.example.demo.Service.ToDoService;
import com.example.demo.Service.UserService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ToDoController {

    @Autowired
    ToDoService toDoService;

    @Autowired 
    ToDoListService toDoListService;

    @Autowired
    UserService uService;

    @GetMapping("/alltodos/{userId}")
    public ResponseEntity<List<ToDoEntity>> getToDos(@PathVariable String userId) {

        Long todolistId = toDoListService.getTodoListByUserId(Long.parseLong(userId));

        List<ToDoEntity> todos = toDoService.getTodosByListId(todolistId);

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        for (ToDoEntity todo : todos) {
            Date date = todo.getDeadline();
            String formattedDate = formatter.format(date);
            todo.setDate(formattedDate);
        }
        System.out.println("test");
        return ResponseEntity.ok(todos);
    }

    @GetMapping("todo/{id}")
    public ToDoEntity getTodo(@PathVariable String id) {
        return toDoService.findToDoByID(Long.parseLong(id));
    }
    
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable String id){
        toDoService.deleteToDo(Long.parseLong(id));
        return ResponseEntity.ok().build();
    }

    @PostMapping("/todo/{userId}")
    public ResponseEntity<ToDoEntity> createTodo(@RequestBody ToDoEntity todo, @PathVariable String userId) {
        System.out.println(todo);
        ToDoListEntity todoListId = uService.findToDoListIdByUserId(userId);
        System.out.println(todoListId);
        return ResponseEntity.ok(toDoService.create(todo.getTitle(), todo.getDeadline(), todoListId));
    }

    @DeleteMapping("/updateScore/{userId}/{todoId}")
    public ResponseEntity<Void> updateUserScoreAndDeleteTodo(@PathVariable String userId, @PathVariable String todoId){
        toDoService.deleteToDo(Long.parseLong(todoId));
        uService.updateScore(Long.parseLong(userId));
        return ResponseEntity.ok().build();
    }

    @PutMapping("/todo/{id}")
    public ToDoEntity updateTodo(@PathVariable String id, @RequestBody ToDoEntity todo) {
        ToDoEntity existingTodo = toDoService.findToDoByID(Long.parseLong(id));
        if (existingTodo != null) {
            
            existingTodo.setTitle(todo.getTitle());
            existingTodo.setDeadline(todo.getDeadline());
            return toDoService.update(existingTodo);
        } else {
            throw new IllegalArgumentException("ToDoEntity mit ID " + id + " existiert nicht.");
        }
    }
}
