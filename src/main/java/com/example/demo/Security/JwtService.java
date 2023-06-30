package com.example.demo.Security;

import java.security.Key;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {

    private static final String SECRET_KEY = "nCUfP+6H0NI2TnsytLi47nGAjKImb+i911aJ503nLPyiYRkxChx9t5Td8axooWPcKTLRcXEV4MeVpjaPVDjChX422az87074SyPrVpto43i5naNmO5AvK/28EPRDvHgu1/la3ovqr+erqaEhZpxJXNw9LSwkz1MwMYcpoBYPl1KOFGyUoDDuKZmzGEIz1CCkDFaNF0xry7GSPZcjWfNpsvXQIi/L6JwNQ9Q1cDo3wFZmZNLm29VZNk+liBDG+gZ2qpcTrr6CJCbLnR/4MORsdvRS4c5R+BKR+Ng6aN8qvzFcuZC6V8RW3KkhfUEAP/9aII/OyGJNbDUCu0jaaVOUk4Xv1N9XOXSZqTaCJP0Lxvw=";

    public String extractUsername(String token){
        return extractClaim(token, Claims::getSubject);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver){
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    public String generateToken(UserDetails userDetails){
        return genereateToken(new HashMap<>(), userDetails);
    }

    public String genereateToken(Map<String, Object> extraClaims, UserDetails userDetails){

        return Jwts.builder()
            .setClaims(extraClaims)
            .setSubject(userDetails.getUsername())
            .setIssuedAt(new Date(System.currentTimeMillis()))
            .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 24))
            .signWith(getSigningKey(), SignatureAlgorithm.HS256)
            .compact();
    }

    public boolean isTokenValid(String token, UserDetails userDetails){
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername())) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new java.util.Date());
    }

    private java.util.Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    private Claims extractAllClaims(String token){
        return Jwts
            .parserBuilder()
            .setSigningKey(getSigningKey())
            .build()
            .parseClaimsJws(token)
            .getBody();
    }

    private Key getSigningKey() {
        
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}

