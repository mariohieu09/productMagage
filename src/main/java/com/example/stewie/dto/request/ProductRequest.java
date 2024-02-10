package com.example.stewie.dto.request;

import com.example.stewie.dto.base.BaseDto;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author [mariohieu09]
 * @since [9/1/2024]
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class        ProductRequest extends BaseDto {
    @Size(max = 20, message = "The product's name must not over 20 characters long")
    private String name;

    @Size(max = 150, message = "The product's description must not over 150 characters long!")
    private String description;

    @Max(value = 1000000, message = "Product price must not get over 1 mil $!")
    private double price;

    private String imageSource;

}
