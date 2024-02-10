package com.example.stewie.controller;

import com.example.stewie.dto.base.GeneralResponse;
import com.example.stewie.dto.request.ProductRequest;
import com.example.stewie.dto.response.ProductResponse;
import com.example.stewie.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
    @PostMapping("/create-product")
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
