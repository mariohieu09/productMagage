package com.example.stewie.security;

import com.example.stewie.constant.UrlConstant;
import com.example.stewie.filter.JwtAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.Arrays;
import java.util.Map;


@EnableWebSecurity
@Configuration
@RequiredArgsConstructor
public class SecurityConfig {
    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    private final AuthenticationProvider authenticationProvider;

    /**
     * Set up a SecurityFilterChain. It secures endpoint and assign what role has permission to access the resources endpoint
     *
     * @param http
     * @return an instance of SecurityFilterChain
     * @throws Exception
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .cors(Customizer.withDefaults())
                .csrf().disable()
                .securityMatcher("/api/**")
                .authorizeHttpRequests(auth -> {
                    auth.requestMatchers(whitelist()).permitAll();
                    for(Map.Entry<String, String> entry : UrlConstant.URL_SECURE.getEndpoints().entrySet()){
                        auth.requestMatchers(entry.getKey()).hasAuthority(entry.getValue());
                    }
                })
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }


    private String[] whitelist(){
        return new String[]{
                "/api/auth/**"
        };
    }
}
