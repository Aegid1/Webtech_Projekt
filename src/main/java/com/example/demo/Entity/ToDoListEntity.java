package com.example.demo.Entity;

//nur eine ToDoList generell oder mehrere ToDoLists möglich (für jeden Tag bspw.)

import jakarta.persistence.*;

import java.util.List;

public class ToDoListEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long toDoListId;

    @Column
    private List<ToDoEntity> toDos;

    private final String name = "Aufgaben";

    //warum enthält hier TodoList eine weitere TodoList?
    @OneToMany
    @JoinColumn(name = "fk_toDoEntity_id")
    private Long fk_toDoListEntity_id;

}
