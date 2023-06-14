package com.example.demo.Entity;

import java.util.List;
import java.util.Set;

import jakarta.persistence.*;

@Entity
public class GroupEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long groupId;

    @Column
    private String name;

    // Inwiefern notwendig ergibt sich aus weiterer Arbeit
    @Column
    private int countOfMembers;

    //eventuell byte[] statt String
    @Column
    private String profilePicture;

    @OneToMany(mappedBy = "fkGroupId")
    private List<UserEntity> fkUserID;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "toDoListId")
    private ToDoListEntity fkToDoListId;

}