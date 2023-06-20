package com.example.demo.Entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.List;

@Entity
public class ToDoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    // @Column
    // private String description;

    @Column
    private Date deadline;

    // @Column
    // private Date creationDate;

//hier wirklich nur der Name der Person, oder person selber?
    // @Column
    // private String nameOfResponsiblePerson;

    // mit Taskstatus noch verknüpfen

    // @ManyToOne(fetch = FetchType.EAGER)
    // @JoinColumn(name = "toDoListId")
    // private ToDoListEntity toDoListId;

    // public void setForeignKey(ToDoListEntity toDoList){ this.toDoListId = toDoList; }

    public Long getId() { return id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public Date getDeadline() { return deadline; }

    public void setDeadline(Date deadline) { this.deadline = deadline; }

    // public ToDoListEntity getToDoListId() { return toDoListId; }
    
    
}
