package com.example.demo.Entity;

//nur eine ToDoList generell oder mehrere ToDoLists möglich (für jeden Tag bspw.)

import jakarta.persistence.*;

import java.util.List;

@Entity
public class ToDoListEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long toDoListId;

    private final String name = "Aufgaben";

    //warum enthält hier TodoList eine weitere TodoList?
    // @OneToMany
    // @JoinColumn(name = "fk_toDoEntity_id")
    // private Long fk_toDoListEntity_id;
    @OneToOne
    @JoinColumn(name = "groupId")
    private GroupEntity fkGroupId;

    @OneToMany(mappedBy = "fkToDoListEntityID")
    private List<ToDoEntity> todos;

    public void addToDoEntity(ToDoEntity todo){ todos.add(todo); }
}
