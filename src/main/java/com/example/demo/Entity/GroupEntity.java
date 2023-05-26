package com.example.demo.Entity;

import java.util.List;

import jakarta.persistence.*;

public class GroupEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private List<UserEntity> members;

    @ManyToOne
    @JoinColumn(name = "fk_userEntity_id")
    private Long fk_userEntity_id;

}
