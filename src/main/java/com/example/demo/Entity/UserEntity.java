package com.example.demo.Entity;

import jakarta.persistence.*;
// import javax.persistence.*;


@Entity
public class UserEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userEntityId;
    
    @Column
    private String firstname;
    
    @Column
    private String lastname;
    
    @Column
    private String email;
    
    @Column
    private String password;
    //hier muss noch ein Foreign-Key auf eine GroupEntity zeigen

    @Column
    private String profilPicture;

    @ManyToOne
    @JoinColumn(name = "groupId")
    private GroupEntity fkGroupId;

    public Long getId() { return userEntityId; }

    public String getFirstname() { return firstname; }

    public void setFirstname(String firstname) { this.firstname = firstname; }

    public String getLastname() { return lastname; }

    public void setLastname(String lastname) { this.lastname = lastname; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

}
