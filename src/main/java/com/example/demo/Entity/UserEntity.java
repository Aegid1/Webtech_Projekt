package com.example.demo.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class UserEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column
    private String firstname;
    
    @Column
    private String lastname;
    
    @Column
    private String email;
    
    @Column
    private String password;
    //hier muss noch ein Foreign-Key auf eine GroupEntity zeigen


    //ich weiß gar nicht warum aber ich glaube man braucht immer nur einen Standard-Konstruktor
    public UserEntity(){}

    public Long getId() { return id; }

    public String getFirstname() { return firstname; }

    public void setFirstname(String firstname) { this.firstname = firstname; }

    public String getLastname() { return lastname; }

    public void setLastname(String lastname) { this.lastname = lastname; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

}
