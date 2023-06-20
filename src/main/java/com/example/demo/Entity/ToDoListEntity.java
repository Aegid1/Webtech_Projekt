package com.example.demo.Entity;

//nur eine ToDoList generell oder mehrere ToDoLists möglich (für jeden Tag bspw.)

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
public class ToDoListEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long toDoListId;
    
    @Column
    private String name = "Aufgaben";

    //warum enthält hier TodoList eine weitere TodoList?
    // @OneToMany
    // @JoinColumn(name = "fk_toDoEntity_id")
    // private Long fk_toDoListEntity_id;
    @OneToOne
    @JoinColumn(name = "groupId")
    private GroupEntity fkGroupId;

    @OneToMany(fetch = FetchType.EAGER)
    private List<ToDoEntity> todos;

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

    public GroupEntity getFkGroupId() {
        return fkGroupId;
    }

    public void setFkGroupId(GroupEntity fkGroupId) {
        this.fkGroupId = fkGroupId;
    }

    public List<ToDoEntity> getTodos() {
        return todos;
    }

    public void setTodos(List<ToDoEntity> todos) {
        this.todos = todos;
    }
    
}
