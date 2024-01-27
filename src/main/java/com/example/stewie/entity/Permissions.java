package com.example.stewie.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * This enum defines permission for every endpoint the application
 */
@Getter
@RequiredArgsConstructor
public enum Permissions {

    VIEW_ALL_USERS("/api/v1/users/all"),
    CREATE_USER("/api/v1/users/create"),
    DELETE_USER("/api/v1/users/delete/{id}"),
    UPDATE_USER("/api/v1/users/update/{id}"),
    GET_USER("/api/v1/users/get/{id}")


    ;
    private final String endpoint;

}
