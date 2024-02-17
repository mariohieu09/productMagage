package com.example.stewie.service;

import com.example.stewie.constant.UrlConstant;
import com.example.stewie.entity.Permissions;
import com.example.stewie.repository.PermissionRepository;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.springframework.web.util.pattern.PathPattern;

import java.util.Iterator;
import java.util.Map;
import java.util.Optional;

@Service
@Slf4j
public class PermissionService {


    @Autowired
    private PermissionRepository permissionRepository;
    @Transactional
    @PostConstruct
    public void persistPermission(){
        Map<Long, Map<String, String>> endpoints = UrlConstant.URL_SECURE.getEndpoints();
//        for(Map.Entry<String, String> entry : endpoints.entrySet()){
//            Optional<Permissions> permissionsOptional = permissionRepository.findByEndpoint(entry.getKey());
//            if(permissionsOptional.isPresent()){
//                Permissions existPermission = permissionsOptional.get();
//                existPermission.setEndpoint(entry.getKey());
//                existPermission.setName(entry.getValue());
//                permissionRepository.save(existPermission);
//            }else{
//                permissionRepository.save(Permissions.builder()
//                                .name(entry.getValue())
//                                .endpoint(entry.getKey())
//                        .build());
//
//            }
//        }
        for(Map.Entry<Long, Map<String, String>> entry : endpoints.entrySet()){
            Optional<Permissions> permissionsOptional = permissionRepository.findById(entry.getKey());
            if(permissionsOptional.isPresent()){
                Iterator<Map.Entry<String, String>> iterator = entry.getValue().entrySet().iterator();
                Permissions existPermission = permissionsOptional.get();
                if(iterator.hasNext()){
                    Map.Entry<String, String> mapEntry = iterator.next();
                    String endPoint = mapEntry.getKey();
                    String permissionName = mapEntry.getValue();
                    existPermission.setEndpoint(endPoint);
                    existPermission.setName(permissionName);
                    permissionRepository.save(existPermission);
                }else{
                    throw new RuntimeException("Have no value in map!");
                }
            }else{
                Iterator<Map.Entry<String, String>> iterator = entry.getValue().entrySet().iterator();
                if(iterator.hasNext()) {
                    Map.Entry<String, String> mapEntry = iterator.next();
                    String endPoint = mapEntry.getKey();
                    String permissionName = mapEntry.getValue();
                    permissionRepository.save(Permissions.builder()
                            .id(entry.getKey())
                            .name(permissionName)
                            .endpoint(endPoint)
                            .build());
                }else{
                    throw new RuntimeException("Have no value in map!");
                }
            }
        }
    }



}
