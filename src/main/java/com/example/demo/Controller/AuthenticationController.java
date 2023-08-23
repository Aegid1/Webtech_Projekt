package com.example.demo.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Security.AuthenticationRequest;
import com.example.demo.Security.AuthenticationResponse;
import com.example.demo.Security.RegisterRequest;
import com.example.demo.Service.AuthenticationService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class AuthenticationController {
    
    private final AuthenticationService service;


    /*
     * endpoint to make a secure register-request
     * when the registration is successful it will deliver the code 200 otherwise 400
     * @param RegisterRequest -> the json request body, that contains the register data
     * @return ResponseEntity<AuthenticationResponse> -> the status with the response of the registration
     */
    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request){
        
        return ResponseEntity.ok(service.register(request));
    }

    /*
     * endpoint to make a secure login-request
     * when the login is successful it will deliver the code 200 otherwise 400
     * @param AuthenticationRequest -> the json request body, that contains the login data
     * @return ResponseEntity<AuthenticationResponse> -> the status with the response of the login
     */
    @PostMapping("/authentication")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request){

        return ResponseEntity.ok(service.authenticate(request));
    }    
}
