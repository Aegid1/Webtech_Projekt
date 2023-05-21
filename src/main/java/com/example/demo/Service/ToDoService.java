package com.example.demo.Service;

import com.example.demo.Repository.ToDoRepository;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Entity.ToDoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ToDoService {

    @Autowired
    ToDoRepository repo;

    public ToDoEntity saveToDo(ToDoEntity toDo){ return repo.save(toDo); }

    public void deleteToDo(ToDoEntity toDo){ repo.delete(toDo); }

    public ToDoEntity findToDoByID(Long id){ return repo.findById(id).orElseThrow(() -> new RuntimeException()); }

}
