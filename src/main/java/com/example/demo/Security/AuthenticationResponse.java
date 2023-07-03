package com.example.demo.Security;

import lombok.Data;

@Data
public class AuthenticationResponse {

    public AuthenticationResponse(String token){
        this.token = token;
    }

    public AuthenticationResponse(){ }

    private String token;
}
