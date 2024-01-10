package com.example.stewie.controller;

import com.example.stewie.dto.base.GeneralResponse;
import com.example.stewie.dto.request.AuthenticationRequest;
import com.example.stewie.dto.response.AuthenticationResponse;
import com.example.stewie.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;


    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public GeneralResponse<AuthenticationResponse> register(@Validated @RequestBody AuthenticationRequest authenticationRequest){
        return authenticationService.register(authenticationRequest);
    }


    @PostMapping("/authenticated")
    @ResponseStatus(HttpStatus.OK)
    public GeneralResponse<AuthenticationResponse> authenticated(@RequestBody AuthenticationRequest authenticationRequest){
        return authenticationService.authenticate(authenticationRequest);
    }
}
