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

    @Column
    private Date deadline;

    @Transient
    private String date;

//hier wirklich nur der Name der Person, oder person selber?
    // @Column
    // private String nameOfResponsiblePerson;

    // mit Taskstatus noch verknüpfen

    public Long getId() { return id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public Date getDeadline() { return deadline; }

    public void setDeadline(Date deadline) { this.deadline = deadline; }

    public String getDate() { return date; }

    public void setDate(String date) { this.date = date; }
    
}
