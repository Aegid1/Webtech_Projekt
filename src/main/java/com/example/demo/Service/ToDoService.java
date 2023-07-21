package com.example.demo.Service;

import com.example.demo.Repository.ToDoRepository;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Entity.ToDoEntity;
import com.example.demo.Entity.ToDoListEntity;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ToDoService {

    @Autowired
    ToDoRepository repo;

    public List<ToDoEntity> getTodosByListId(Long todoListId) {

        List<ToDoEntity> todos = repo.findByToDoListId(todoListId);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        for (ToDoEntity todo : todos) {

            Date date = todo.getDeadline();
            String formattedDate = formatter.format(date);
            todo.setDate(formattedDate);
        }

        return todos;
    }

    public void deleteToDo(Long id) {
        repo.deleteById(id);
    }

    public ToDoEntity findTodoById(Long id){

        return repo.findById(id).orElseThrow(() -> new RuntimeException());
    }

    public ToDoEntity updateTodoById(Long id, ToDoEntity todo) {

        ToDoEntity existingTodo = findTodoById(id);

        if (existingTodo != null) {
            
            existingTodo.setTitle(todo.getTitle());
            existingTodo.setDeadline(todo.getDeadline());
            return update(existingTodo);
        } else {
            throw new IllegalArgumentException("ToDoEntity mit ID " + id + " existiert nicht.");
        }

    }

    public void setTitle(Long id, String title) {
        ToDoEntity todo = repo.findById(id).orElseThrow(() -> new RuntimeException());
        todo.setTitle(title);
        repo.save(todo);
    }

    public void setDeadline(Long id, Date deadline) {
        ToDoEntity todo = repo.findById(id).orElseThrow(() -> new RuntimeException());
        todo.setDeadline(deadline);
        repo.save(todo);
    }

    public ToDoEntity create(String title, Date deadline, ToDoListEntity toDoListId) {


        ToDoEntity newToDo = new ToDoEntity();
        newToDo.setTitle(title);
        newToDo.setDeadline(deadline);
        newToDo.setToDoList(toDoListId);
        newToDo.setEditMode(false);
        
        return repo.save(newToDo);
    }

    public ToDoEntity update(ToDoEntity updatedTodo) {
        ToDoEntity existingTodo = repo.findById(updatedTodo.getId()).orElseThrow(() -> new RuntimeException());
        existingTodo.setTitle(updatedTodo.getTitle());
        existingTodo.setDeadline(updatedTodo.getDeadline());
        return repo.save(existingTodo);
    }
}
