package com.example.demo.Entity;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
public class ToDoEntity {

    public ToDoEntity(){ }
    
    public ToDoEntity(Object toDoId, Object deadline,  Object editMode, Object title){
        this.toDoId = (Long) (toDoId);
        this.deadline = Date.valueOf(deadline.toString());
        this.editMode = (boolean) editMode;
        this.title = String.valueOf(title);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long toDoId;

    @Column
    private String title;

    @Column
    private boolean editMode;

    @Column
    private Date deadline;

    @ManyToOne
    @JoinColumn(name = "groupId")
    private GroupEntity groupId;

    public Long getId() { return toDoId; }

    public void setId(Long id) { this.toDoId = id; }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public boolean getEditMode() { return this.editMode; }

    public void setEditMode(boolean editMode) { this.editMode = editMode; }

    public Date getDeadline() { return deadline; }

    public void setDeadline(Date deadline) { this.deadline = deadline; }

    public Long getToDoId() { return toDoId; }

    public void setToDoId(Long toDoId) { this.toDoId = toDoId; }

    public GroupEntity getGroup() { return groupId; }

    public void setGroup(GroupEntity group) { this.groupId = group; }

    
}
