package com.example.stewie.dto.response;

import com.example.stewie.dto.base.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductResponse extends BaseDto {

    private Long id;

    private String name;
    private String description;

    private double price;

    private String imageSource;
}