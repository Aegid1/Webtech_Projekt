package com.example.demo.Service;

import com.example.demo.Repository.ToDoRepository;
import com.example.demo.Entity.ToDoEntity;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ToDoService {

    @Autowired
    ToDoRepository repo;

    public List<ToDoEntity> getTodosByListId(Long todoListId) {
        return repo.findByToDoListId(todoListId);
    }

    public void deleteToDo(Long id) {
        repo.deleteById(id);
    }

    public ToDoEntity findToDoByID(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException());
    }

    public void setTitle(Long id, String title) {
        ToDoEntity todo = repo.findById(id).orElseThrow(() -> new RuntimeException());
        todo.setTitle(title);
        repo.save(todo);
    }

    public void setDescription(Long id, String description) {
        ToDoEntity todo = repo.findById(id).orElseThrow(() -> new RuntimeException());
        todo.setDescription(description);
        repo.save(todo);
    }

    public void setDeadline(Long id, Date deadline) {
        ToDoEntity todo = repo.findById(id).orElseThrow(() -> new RuntimeException());
        todo.setDeadline(deadline);
        repo.save(todo);
    }

    public ToDoEntity create(String title, String description, Date deadline) {
        ToDoEntity newToDo = new ToDoEntity();
        newToDo.setTitle(title);
        newToDo.setDescription(description);
        newToDo.setDeadline(deadline);
        return repo.save(newToDo);
    }

    public ToDoEntity update(ToDoEntity updatedTodo) {
        ToDoEntity existingTodo = repo.findById(updatedTodo.getId()).orElseThrow(() -> new RuntimeException());
        existingTodo.setTitle(updatedTodo.getTitle());
        existingTodo.setDescription(updatedTodo.getDescription());
        existingTodo.setDeadline(updatedTodo.getDeadline());
        return repo.save(existingTodo);
    }
}
