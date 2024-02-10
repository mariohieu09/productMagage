package com.example.stewie.service;

import com.example.stewie.constant.RoleConstant;
import com.example.stewie.entity.Permissions;
import com.example.stewie.entity.User;
import com.example.stewie.entity.UserRole;
import com.example.stewie.repository.PermissionRepository;
import com.example.stewie.repository.RoleRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class RoleService {


    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PermissionRepository permissionRepository;
    @Transactional
    @PostConstruct
    public void persistRole(){
        List<RoleConstant> list = Arrays.asList(RoleConstant.values());
        for(RoleConstant roleConstant : list){
            Optional<UserRole> userRoleOptional = roleRepository.findByName(roleConstant.name());
            if(userRoleOptional.isPresent()){
                UserRole userRole = userRoleOptional.get();
                roleRepository.save(userRole);
            }else{
                roleRepository.save(UserRole.builder()
                                .name(roleConstant.name())
                                .permissionsSet(new HashSet<>(
                                        roleConstant.getPermissions()
                                                .stream()
                                                .map(s -> permissionRepository.findByName(s))
                                                .toList()
                                ))
                        .build());
            }
        }
    }
}
