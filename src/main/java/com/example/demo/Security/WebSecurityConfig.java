package com.example.demo.Security;

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
            .authorizeHttpRequests()
            .requestMatchers(new AntPathRequestMatcher("/db-console/**"), 
                            new AntPathRequestMatcher("/todo/**"),
                            new AntPathRequestMatcher("/register"),
                            new AntPathRequestMatcher("/getGroup/**")
                            )
            .permitAll()
            .anyRequest()
            .authenticated()
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
        configuration.addAllowedOrigin("*"); // Erlaubt den Zugriff von allen Ursprüngen, hier kannst du spezifische Ursprünge angeben
        configuration.addAllowedMethod("*"); // Erlaubt den Zugriff für alle HTTP-Methoden (GET, POST, etc.)
        configuration.addAllowedHeader("*"); // Erlaubt den Zugriff für alle Header-Felder
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}