package com.example.demo.Entity;

//only one ToDoList for a group? Or should there be more lists, for different occasions

import jakarta.persistence.*;

@Entity
public class ToDoListEntity {

    public ToDoListEntity(Long id, String name, Long fkGroupId){
        this.toDoListId = id;
        this.name = name;
        this.fkGroupId = fkGroupId;
    }

    public ToDoListEntity(){ }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long toDoListId;
    
    @Column
    private String name = "Aufgaben";
    
    @Column
    private Long fkGroupId;

    public Long getToDoListId() { return toDoListId; }

    public void setToDoListId(Long toDoListId) { this.toDoListId = toDoListId; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public Long getFkGroupId() { return fkGroupId; }

    public void setFkGroupId(Long fkGroupId) { this.fkGroupId = fkGroupId; }
    
}
