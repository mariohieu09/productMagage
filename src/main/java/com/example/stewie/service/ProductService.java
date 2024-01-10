package com.example.stewie.service;

import com.example.stewie.dto.request.ProductRequest;
import com.example.stewie.dto.response.ProductResponse;
import com.example.stewie.entity.Product;
import com.example.stewie.repository.BaseRepository;
import com.example.stewie.repository.ProductRepository;
import com.example.stewie.service.base.AbstractGeneralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService extends AbstractGeneralService<ProductRequest, Product, ProductResponse> {

    @Autowired
    private ProductRepository productRepository;
    public ProductService(BaseRepository<Product> entityRepository) {
        super(entityRepository);
    }

    @Override
    public Product convertToEntity(ProductRequest dto) {
        return Product.builder()
                .name(dto.getName())
                .description(dto.getDescription())
                .imageSource(dto.getImageSource())
                .price(dto.getPrice())
                .build();
    }

    @Override
    public ProductResponse convertToDto(Product entity) {
        return ProductResponse.builder()
                .id(entity.getId())
                .name(entity.getName())
                .price(entity.getPrice())
                .description(entity.getDescription())
                .imageSource(entity.getImageSource())
                .build();
    }
}
