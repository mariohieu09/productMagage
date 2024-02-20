package com.example.stewie.service;

import com.example.stewie.constant.UrlConstant;
import com.example.stewie.dto.request.ExtraPermissionDto;
import com.example.stewie.dto.response.UserResponse;
import com.example.stewie.entity.Permissions;
import com.example.stewie.entity.User;
import com.example.stewie.exception.NotFoundException;
import com.example.stewie.repository.PermissionRepository;
import com.example.stewie.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.springframework.web.util.pattern.PathPattern;

import java.util.*;

@Service
@Slf4j
@Order(1)
public class PermissionService {


    @Autowired
    private PermissionRepository permissionRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;
    @Transactional
    @PostConstruct
    public void persistPermission(){
        Map<String, String> permissionSet = UrlConstant.URL_SECURE.getEndpoints();
        for(Map.Entry<String, String> entry : permissionSet.entrySet()){
            Optional<Permissions> permissionsOptional = permissionRepository.findByName(entry.getValue());
            if(permissionsOptional.isPresent()){
                Permissions permission = permissionsOptional.get();
                permission.setName(permission.getName());
                permission.setEndpoint(permission.getEndpoint());
                permissionRepository.save(permission);
            }else {
                permissionRepository.save(Permissions.builder()
                                .endpoint(entry.getKey())
                                .name(entry.getValue())
                        .build());
            }
        }
    }

    public List<Permissions> getAll(){
        return permissionRepository.findAll();
    }

    public UserResponse updatePermission(ExtraPermissionDto extraPermissionDto){
        Optional<Permissions> permissionsOptional = permissionRepository.findById(extraPermissionDto.getPermissionId());
        Optional<User> userOptional = userRepository.findById(extraPermissionDto.getUserId());
        Permissions permissions;
        User user;
        if(permissionsOptional.isPresent()){
            permissions =  permissionsOptional.get();
        }else{
            throw new NotFoundException();
        }
        if(userOptional.isPresent()){
            user = userOptional.get();
        }else{
            throw new NotFoundException();
        }
        Set<Permissions> extraPermission = user.getExtraPermission();
        extraPermission.add(permissions);
        userRepository.save(user);
        return userService.convertToDto(user);
    }

}
