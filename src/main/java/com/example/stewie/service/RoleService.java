package com.example.stewie.service;

import com.example.stewie.constant.RoleConstant;
import com.example.stewie.entity.Permissions;
import com.example.stewie.entity.User;
import com.example.stewie.entity.UserRole;
import com.example.stewie.repository.PermissionRepository;
import com.example.stewie.repository.RoleRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Order(2)
@DependsOn("permissionService")
public class RoleService {


    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PermissionRepository permissionRepository;
    @Transactional
    @PostConstruct
    public void persistRole(){
        List<RoleConstant> list = List.of(RoleConstant.values());
        for(RoleConstant roleConstant : list){
            Optional<UserRole> userRoleOptional = roleRepository.findByName(roleConstant.name());
            if(userRoleOptional.isPresent()){
                UserRole userRole = userRoleOptional.get();
                userRole.setPermissionsSet(new HashSet<>(getAllPermission(roleConstant)));
                roleRepository.save(userRole);
            }else{
                roleRepository.save(UserRole.builder()
                                .name(roleConstant.name())
                                .permissionsSet(new HashSet<>(
                                        roleConstant.getPermission()
                                                .stream()
                                                .map(s -> permissionRepository.findByName(s).get())
                                                .toList()
                                ))
                        .build());
            }
        }
    }

    private List<Permissions> getAllPermission(RoleConstant roleConstant){
        List<Permissions> permissions = new ArrayList<>();
        for(String name : roleConstant.getPermission()){
            permissions.add(permissionRepository.findByName(name).get());
        }
        return permissions;
    }

}
