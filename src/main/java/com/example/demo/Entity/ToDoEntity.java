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

    @ManyToOne
    @JoinColumn(name = "toDoListId")
    private ToDoListEntity fkToDoListEntityID;

    public void setForeignKey(ToDoListEntity toDoList){ this.fkToDoListEntityID = toDoList; }
    
}
