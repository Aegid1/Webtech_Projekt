package com.example.demo.Service;

import com.example.demo.Repository.ToDoListRepository;
import com.example.demo.Repository.ToDoRepository;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Entity.ToDoEntity;
import com.example.demo.Entity.ToDoListEntity;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ToDoService {

    @Autowired
    ToDoRepository repo;

    @Autowired
    ToDoListRepository listRepo;

    public ToDoEntity saveToDo(ToDoEntity toDo, Long id){ 
        
        //Dieser Teil kümmert sich darum die Spalte der ToDoList zu updaten
        Optional<ToDoListEntity> toDoList = listRepo.findById(id);
        toDoList.get().addToDoEntity(toDo);
        listRepo.save(toDoList.get());

        //Dieser Teil kümmert sich darum das tatsächliche toDo abzuspeichern
        toDo.setForeignKey(toDoList.get());
        return repo.save(toDo); 
    }

    public void deleteToDo(ToDoEntity toDo){ repo.delete(toDo); }

    public ToDoEntity findToDoByID(Long id){ return repo.findById(id).orElseThrow(() -> new RuntimeException()); }

}
