package com.example.stewie.controller;

import com.example.stewie.dto.base.GeneralResponse;
import com.example.stewie.dto.request.ExtraPermissionDto;
import com.example.stewie.dto.response.UserResponse;
import com.example.stewie.entity.Permissions;
import com.example.stewie.service.PermissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/permission")
public class PermissionController {

    private final PermissionService permissionService;
    @RequestMapping("/get-all")
    @ResponseStatus(HttpStatus.OK)
    public GeneralResponse<List<Permissions>> getAllPermission(){
        return GeneralResponse.ofSuccess(permissionService.getAll(), "Success!");
    }

    @PostMapping("/give-extra")
    @ResponseStatus(HttpStatus.OK)
    public GeneralResponse<UserResponse> giveExtraPermission(@RequestBody ExtraPermissionDto extraPermissionDto){
        return GeneralResponse.ofSuccess(permissionService.updatePermission(extraPermissionDto), "Update successfully!");
    }
}
