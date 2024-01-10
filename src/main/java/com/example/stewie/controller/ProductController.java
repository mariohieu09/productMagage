package com.example.stewie.controller;

import com.example.stewie.dto.base.GeneralResponse;
import com.example.stewie.dto.request.ProductRequest;
import com.example.stewie.dto.response.ProductResponse;
import com.example.stewie.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 * @author [mariohieu09]
 * @since [9/1/2024]
 */

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/product")
public class ProductController {

    private final ProductService productService;


    @GetMapping("/get-all")
    @ResponseStatus(HttpStatus.OK)
    public GeneralResponse<List<ProductResponse>> getAllProducts(){
        return GeneralResponse.ofSuccess(productService.getAll(), "List products");
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public GeneralResponse<ProductResponse> createProduct(@Validated @RequestBody ProductRequest productRequest){
        return GeneralResponse.ofCreate(productService.save(productRequest), "Create successful!");
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GeneralResponse<ProductResponse> getProductById(@PathVariable Long id){
        return GeneralResponse.ofSuccess(productService.getById(id), "Product by id");
    }


}
