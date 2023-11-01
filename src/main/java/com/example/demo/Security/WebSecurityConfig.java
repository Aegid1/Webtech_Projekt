package com.example.demo.Security;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import lombok.RequiredArgsConstructor;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

// Hier geht's zur Webseite -> https://spring.io/guides/gs/securing-web/

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig {

    private final JwtAuthenticationFilter jwtAuthFilter;

    private final AuthenticationProvider authenticationProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{

        http
            .csrf()
            .disable()
            .cors()
            .and()
            .formLogin()
            .disable() 
            .authorizeHttpRequests()
            .requestMatchers(new AntPathRequestMatcher("/db-console/**"),
                    new AntPathRequestMatcher("/todo/**", "GET"),
                    new AntPathRequestMatcher("/register", "POST"),
                    new AntPathRequestMatcher("/authentication/**", "POST"),
                    new AntPathRequestMatcher("/getGroup/**"),
                    new AntPathRequestMatcher("/userEmail/**"),
                    new AntPathRequestMatcher("/todo/**"),
                    new AntPathRequestMatcher("/delete/**"),
                    new AntPathRequestMatcher("/updateScore/**"),
                    new AntPathRequestMatcher("/alltodos/**", "GET")
                                                    
            ).permitAll()
            .and()
            .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
            .authenticationProvider(authenticationProvider)
            .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

        http.headers().frameOptions().disable();

        return http.build();

    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration configuration = new CorsConfiguration();
//Hier muss gegen Ende localhost:3001 rausgenommen werden
        configuration.setAllowedOrigins(List.of("http://localhost:3001", "http://localhost:8080")); 
        configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE"));
        configuration.setAllowedHeaders(List.of("Authorization", "Cache-Control", "Content-Type"));
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}                                                       