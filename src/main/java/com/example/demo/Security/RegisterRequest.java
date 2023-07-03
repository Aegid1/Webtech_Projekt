package com.example.demo.Security;
import lombok.Data;

@Data
public class RegisterRequest {

    public RegisterRequest(){ }

    public RegisterRequest(String firstname, String lastname, String email, String password){
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
    }

    private String firstname;

    private String lastname;
    
    private String email;
    
    private String password;

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public CharSequence getPassword() {
        return password;
    }
}
