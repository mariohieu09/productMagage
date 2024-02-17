package com.example.stewie.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Map;
@RequiredArgsConstructor
public enum UrlConstant {
    URL_SECURE(
            Map.of(
                    1L, Map.of("/api/product/{id}", "VIEW_PRODUCT"),
                    2L, Map.of("/api/product/get-all", "GET_ALL_PRODUCT"),
                    3L, Map.of("/api/product/create-product", "CREATE_PRODUCT"),
                    4L, Map.of("/api/admin/all-users", "GET_ALL_USERS")

            )
    );

    @Getter
    private final Map<Long, Map<String, String>> endpoints;


}
