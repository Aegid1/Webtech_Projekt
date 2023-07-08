package com.example.demo.Entity;

//nur eine ToDoList generell oder mehrere ToDoLists möglich (für jeden Tag bspw.)

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
public class ToDoListEntity{

    public ToDoListEntity(Long id, String name, Long fkGroupId){
        this.toDoListId = id;
        this.name = name;
        this.fkGroupId = fkGroupId;
    }

    public ToDoListEntity(){

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long toDoListId;
    
    @Column
    private String name = "Aufgaben";
    
    @Column
    private Long fkGroupId;

    // @OneToMany(fetch = FetchType.EAGER)
    // @JoinColumn(name = "toDoId")
    // private List<ToDoEntity> todos;

    //public void addToDoEntity(ToDoEntity todo){ todos.add(todo); }

    public Long getToDoListId() {
        return toDoListId;
    }

    public void setToDoListId(Long toDoListId) {
        this.toDoListId = toDoListId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getFkGroupId() {
        return fkGroupId;
    }

    public void setFkGroupId(Long fkGroupId) {
        this.fkGroupId = fkGroupId;
    }

    // public List<ToDoEntity> getTodos() {
        // return todos;
    // }
// 
    // public void setTodos(List<ToDoEntity> todos) {
        // this.todos = todos;
    // }
    
}
