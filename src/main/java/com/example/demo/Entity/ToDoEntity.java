package com.example.demo.Entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

@Entity
public class ToDoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long toDoId;

    @Column
    private String title;

    @Column
    private String description;

    @Column
    private Date deadline;

    @Transient
    private String date;

    @ManyToOne
    @JoinColumn(name = "toDoListId")
    private ToDoListEntity toDoList;

    public Long getId() {
        return toDoId;
    }

    public void setId(Long id) {
        this.toDoId = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
        // Hier können weitere Verarbeitungen oder Validierungen für das Datum erfolgen
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Long getToDoId() {
        return toDoId;
    }

    public void setToDoId(Long toDoId) {
        this.toDoId = toDoId;
    }

    public ToDoListEntity getToDoList() {
        return toDoList;
    }

    public void setToDoList(ToDoListEntity toDoList) {
        this.toDoList = toDoList;
    }

    
}
