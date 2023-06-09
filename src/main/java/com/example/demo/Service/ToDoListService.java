package com.example.demo.Service;

import com.example.demo.Entity.ToDoEntity;
import com.example.demo.Entity.ToDoListEntity;
import com.example.demo.Repository.ToDoListRepository;
import com.example.demo.Repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ToDoListService {

    @Autowired
    ToDoListRepository repo;

    public ToDoListEntity saveToDoList(ToDoListEntity toDoList){ return repo.save(toDoList); }

    public void deleteToDoList(ToDoListEntity toDoList){ repo.delete(toDoList); }

    public ToDoListEntity findToDoListByID(Long id){ return repo.findById(id).orElseThrow(() -> new RuntimeException()); }

    public Long getTodoListByUserId(Long userId){ return repo.findByToDoListId(userId); }
        
}

