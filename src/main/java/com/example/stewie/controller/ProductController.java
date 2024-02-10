package com.example.stewie.controller;

import com.example.stewie.dto.base.GeneralResponse;
import com.example.stewie.dto.request.ProductRequest;
import com.example.stewie.dto.response.ProductResponse;
import com.example.stewie.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.List;
import java.util.Map;

/**
 *
 * @author [mariohieu09]
 * @since [9/1/2024]
 */

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/product")
@Slf4j
public class ProductController {

    private final ProductService productService;

    /**
     * Retrieves a list of all products.
     *
     * @return GeneralResponse<List<ProductResponse>> - Response containing the list of products.
     */
    @GetMapping("/get-all")
    @ResponseStatus(HttpStatus.OK)
    public GeneralResponse<List<ProductResponse>> getAllProducts(){
        return GeneralResponse.ofSuccess(productService.getAll(), "List products");
    }
    /**
     * Creates a new product.
     *
     * @param productRequest ProductRequest - The request payload for creating a product.
     * @return GeneralResponse<ProductResponse> - Response containing the created product.
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public GeneralResponse<ProductResponse> createProduct(@Validated @RequestBody ProductRequest productRequest){
        return GeneralResponse.ofCreate(productService.save(productRequest), "Create successful!");
    }

    /**
     * Retrieves a product by its unique identifier.
     *
     * @param id Long - The unique identifier of the product.
     * @return GeneralResponse<ProductResponse> - Response containing the product information.
     */
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GeneralResponse<ProductResponse> getProductById(@PathVariable Long id){
        return GeneralResponse.ofSuccess(productService.getById(id), "Product by id");
    }




}
