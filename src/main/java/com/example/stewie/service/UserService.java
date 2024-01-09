package com.example.stewie.service;

import com.example.stewie.dto.request.UserRequest;
import com.example.stewie.dto.response.UserResponse;
import com.example.stewie.entity.User;
import com.example.stewie.repository.BaseRepository;
import com.example.stewie.repository.UserRepository;
import com.example.stewie.service.base.AbstractGeneralService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserService extends AbstractGeneralService<UserRequest, User, UserResponse> {


    @Autowired
    private UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        super(userRepository);
    }



    @Override
    public User convertToEntity(UserRequest dto) {
        return User.builder()
                .username(dto.getUsername())
                .encoderString(dto.getPassword())
                .build();
    }

    @Override
    public UserResponse convertToDto(User entity) {
        return UserResponse.builder()
                .createdAt(entity.getCreatedAt())
                .username(entity.getUsername())
                .id(entity.getId())
                .build();
    }


}
