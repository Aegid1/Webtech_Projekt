package com.example.demo.Entity;
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
    private Integer countOfMembers;

    //eventuell byte[] statt String
    @Column
    private String profilePicture;

    @Column
    private String scoreSum;

    private Long fkToDoListId;

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCountOfMembers() {
        return countOfMembers;
    }

    public void setCountOfMembers(Integer countOfMembers) {
        this.countOfMembers = countOfMembers;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public String getScoreSum() {
        return scoreSum;
    }

    public void setScoreSum(String scoreSum) {
        this.scoreSum = scoreSum;
    }

    public Long getFkToDoListId() {
        return fkToDoListId;
    }

    public void setFkToDoListId(Long fkToDoListId) {
        this.fkToDoListId = fkToDoListId;
    }


    
}