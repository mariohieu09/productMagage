package com.example.stewie.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Set;

@RequiredArgsConstructor
public enum RoleConstant {
    ADMIN(Set.of(
            "VIEW_PRODUCT",
            "GET_ALL_PRODUCT",
            "CREATE_USER",
            "DELETE_USER",
            "UPDATE_USER",
            "GET_USER"
    )),
    USER(Set.of(
            "VIEW_PRODUCT",
            "GET_ALL_PRODUCT",
            "CREATE_PRODUCT"
    ))

    ;
    @Getter
    private final Set<String> permissions;
}
