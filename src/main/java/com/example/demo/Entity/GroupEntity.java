package com.example.demo.Entity;

import java.util.List;
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

    @Column
    private String scoreSum;

    // @OneToMany(fetch = FetchType.EAGER)
    // private List<UserEntity> users;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "toDoListId", nullable = true)
    private ToDoListEntity fkToDoListId;

}