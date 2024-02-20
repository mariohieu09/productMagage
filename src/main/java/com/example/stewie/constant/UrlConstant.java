package com.example.stewie.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Map;
@RequiredArgsConstructor
public enum UrlConstant {
    URL_SECURE(
            Map.of(
                    "/api/product/{id}", "VIEW_PRODUCT",
                    "/api/product/get-all", "GET_ALL_PRODUCT"
                    ,"/api/product/create-product", "CREATE_PRODUCT"
                    ,"/api/admin/all-users", "GET_ALL_USERS"
                    ,"/api/permission/get-all", "GET_ALL_PERMISSIONS"
                    ,"/api/permission/give-extra", "GIVE_EXTRA_PERMISSIONS"
            )
    );

    @Getter
    private final Map<String, String> endpoints;


}
