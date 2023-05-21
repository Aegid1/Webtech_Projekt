package com.example.demo.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.sql.Date;
import java.util.List;

public class ToDoEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private Date deadline;

//hier wirklich nur der Name der Person, oder person selber?
    @Column
    private String nameOfResponsiblePerson;


}
