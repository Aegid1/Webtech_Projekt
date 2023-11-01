package com.example.demo.Entity;

import java.util.Collection;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.*;
// import javax.persistence.*;

@Entity
public class UserEntity implements UserDetails{
    
    public UserEntity(String firstname, String lastname, String email, String password, String profilepicture, String score, Role role){
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.profilPicture = profilepicture;
        this.score = score;
        this.role = role;
    }

    public UserEntity(String firstname, String lastname, String email, String password, Role role){
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userEntityId;
    
    @Column
    private String firstname;
    
    @Column
    private String lastname;
    
    @Column
    private String email;

    @JsonIgnore
    @Column
    private String password;

    @Column
    private String profilPicture;

    @Column
    private String score;

    @Enumerated(EnumType.STRING)
    private Role role;

    @ManyToOne
    @JoinColumn(name = "groupId")
    private GroupEntity groupId;

    public UserEntity() { }

    public void setId(Long id) { this.userEntityId= id; }

    public Long getId() { return userEntityId; }

    public String getFirstname() { return firstname; }

    public void setFirstname(String firstname) { this.firstname = firstname; }

    public String getLastname() { return lastname; }

    public void setLastname(String lastname) { this.lastname = lastname; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }
    
    public String getProfilPicture() { return profilPicture; }

    public void setProfilPicture(String profilPicture) { this.profilPicture = profilPicture; }

    public String getScore() { return score; }

    public void setScore(String score) { this.score = score; }

    public Role getRole() { return role; }

    public void setRole(Role role) { this.role = role; }

    @Override
    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getUsername() { return this.email; }

    @Override
    public boolean isAccountNonExpired() { return true; }

    @Override
    public boolean isAccountNonLocked() { return true; }

    @Override
    public boolean isCredentialsNonExpired() { return true; }

    @Override
    public boolean isEnabled() { return true; }

}
