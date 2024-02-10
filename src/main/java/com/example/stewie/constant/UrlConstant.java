package com.example.stewie.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Map;
import java.util.Set;
@RequiredArgsConstructor
public enum UrlConstant {
    URL_SECURE(
            Map.of(
                  "/api/product/{id}", "VIEW_PRODUCT",
                    "/api/product/get-all", "GET_ALL_PRODUCT"
            )
    );

    @Getter
    private final Map<String, String> endpoints;


}
