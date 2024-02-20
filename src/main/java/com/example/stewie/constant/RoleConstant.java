package com.example.stewie.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Collection;
import java.util.Set;

@RequiredArgsConstructor
public enum RoleConstant {
    ADMIN(Set.of(
            "VIEW_PRODUCT",
            "GET_ALL_PRODUCT",
            "CREATE_PRODUCT",
            "GET_ALL_USERS",
            "GET_ALL_PERMISSIONS",
            "GIVE_EXTRA_PERMISSIONS"
    ))

    , USER(Set.of(
            "VIEW_PRODUCT",
            "GET_ALL_PRODUCT",
            "CREATE_PRODUCT"
    ));

    @Getter
    private final Set<String> permission;
}
