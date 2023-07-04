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

    // nimmt alle ToDos mit einer ToDoListEntity-ID, nimmt jede Deadline und wandelt sie von DATE in String für das JSON-Objekt um
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
    public ToDoEntity getTodo(@PathVariable String id) {
        return toDoService.findToDoByID(Long.parseLong(id));
    }

    @DeleteMapping("delete/{id}")
    public void deleteTodo(@PathVariable String id){
        toDoService.deleteToDo(Long.parseLong(id));
    }

    //sind hier aber alle Werte abedeckt? Eigentlich würde todo.getDate fehlen  bspw.
    @PostMapping("/todo")
    public ToDoEntity createTodo(@RequestBody ToDoEntity todo) {
        return toDoService.create(todo.getTitle(), todo.getDescription(), todo.getDeadline());
    }


    @PutMapping("/todo/{id}")
    public ToDoEntity updateTodo(@PathVariable String id, @RequestBody ToDoEntity todo) {
        // Fügen Sie den Code für das Aktualisieren eines ToDos hinzu (z. B. Aufruf der entsprechenden Service-Methode)
        ToDoEntity existingTodo = toDoService.findToDoByID(Long.parseLong(id));
        if (existingTodo != null) {
            existingTodo.setTitle(todo.getTitle());
            existingTodo.setDescription(todo.getDescription());
            existingTodo.setDeadline(todo.getDeadline());
            return toDoService.update(existingTodo);
        } else {
            throw new IllegalArgumentException("ToDoEntity mit ID " + id + " existiert nicht.");
        }
    }
}
