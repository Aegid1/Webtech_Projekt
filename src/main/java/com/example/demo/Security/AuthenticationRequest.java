package com.example.demo.Security;

import lombok.Data;

@Data
public class AuthenticationRequest {

    public AuthenticationRequest(){ }

    public AuthenticationRequest(String email, String password){
        this.email = email;
        this.password = password;
    }

    private String email;

    private String password;
}
