package com.example.demo.Entity;
import jakarta.persistence.*;

@Entity
public class GroupEntity {
    
    public GroupEntity(int memberCount, String name, String profilePicture, String scoreSum, boolean permission){

        this.countOfMembers = memberCount;
        this.name = name;
        this.profilePicture = profilePicture;
        this.scoreSum = scoreSum;
        this.locationPermission = permission;

    }

    public GroupEntity(){ }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long groupId;

    @Column
    private String name;

    // in what way necessary, is going to be shown during the project
    @Column
    private int countOfMembers;

    //maybe byte[] instead of String
    @Column
    private String profilePicture;

    // in what way necessary, is going to be shown during the project
    @Column
    private String scoreSum;

    @Column
    private boolean locationPermission;
    
    public void setLocationPermission(Boolean permission){ this.locationPermission = permission; }

    public boolean getLocationPermission(){ return locationPermission; }

    public Long getGroupId() { return groupId; }

    public void setGroupId(Long groupId) { this.groupId = groupId; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public Integer getCountOfMembers() { return countOfMembers; }

    public void setCountOfMembers(Integer countOfMembers) { this.countOfMembers = countOfMembers; }

    public String getProfilePicture() { return profilePicture; }

    public void setProfilePicture(String profilePicture) { this.profilePicture = profilePicture; }

    public String getScoreSum() { return scoreSum; }

    public void setScoreSum(String scoreSum) { this.scoreSum = scoreSum; }
    
}