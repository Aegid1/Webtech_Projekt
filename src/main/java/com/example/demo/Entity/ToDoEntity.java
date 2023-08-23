package com.example.demo.Entity;

import jakarta.persistence.*;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class ToDoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long toDoId;

    @Column
    private String title;

    @Column
    private boolean editMode;

    @Column
    private Date deadline;

    @Transient
    private String date;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "toDoListId")
    private ToDoListEntity toDoList;

    public Long getId() { return toDoId; }

    public void setId(Long id) { this.toDoId = id; }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public boolean getEditMode() { return this.editMode; }

    public void setEditMode(boolean editMode) { this.editMode = editMode; }

    public Date getDeadline() { return deadline; }

    public void setDeadline(Date deadline) { this.deadline = deadline; }

    public String getDate() { return date; }

    public void setDate(String date) { this.date = date; }

    public Long getToDoId() { return toDoId; }

    public void setToDoId(Long toDoId) { this.toDoId = toDoId; }

    public ToDoListEntity getToDoList() { return toDoList; }

    public void setToDoList(ToDoListEntity toDoList) { this.toDoList = toDoList; }

    
}
