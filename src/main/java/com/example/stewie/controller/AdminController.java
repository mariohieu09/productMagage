package com.example.stewie.controller;

import com.example.stewie.dto.base.GeneralResponse;
import com.example.stewie.dto.response.UserResponse;
import com.example.stewie.entity.User;
import com.example.stewie.repository.UserRepository;
import com.example.stewie.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/admin")
public class AdminController {
    private final UserService userService;

    @GetMapping("/all-users")
    public GeneralResponse<List<UserResponse>> getAllUser(){
        return GeneralResponse.ofSuccess(userService.getAll(), "Success!");
    }

}
