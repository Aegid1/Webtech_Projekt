package com.example.demo.Service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Role;
import com.example.demo.Entity.UserEntity;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Security.AuthenticationRequest;
import com.example.demo.Security.AuthenticationResponse;
import com.example.demo.Security.JwtService;
import com.example.demo.Security.RegisterRequest;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    /*
     * registers a user in the UserRepository/Database
     * @Param RegisterRequest -> the request that contains the data of the user
     * @return AuthenticationResponse -> response of the jwt authentication process
     */
    public AuthenticationResponse register(RegisterRequest request) {
        var user = new UserEntity(request.getFirstname(), request.getLastname(), request.getEmail(), passwordEncoder.encode(request.getPassword()), Role.USER);
        repository.save(user);
        var jwtToken = jwtService.generateToken(user);

        return new AuthenticationResponse(jwtToken);
    }

    /*
     * authenticates the user when the email and password of the request from the user exist in the database 
     * @Param AuthenticationRequest -> the request that is going to be checked 
     * @return AuthenticationResponse -> the response of the authentication process
     */
    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));

        var user = repository.findByEmail(request.getEmail()).orElseThrow();
        
        var jwtToken = jwtService.generateToken(user);

        return new AuthenticationResponse(jwtToken);
    }
    
}
