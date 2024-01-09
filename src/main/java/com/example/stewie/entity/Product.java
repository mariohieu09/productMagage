package com.example.stewie.entity;

import com.example.stewie.entity.base.ImmutableIdEntity;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



/**
 * An entity class representing a product, extending ImmutableIdEntity for an immutable identifier.
 * Each product has a unique identifier ('id') and includes additional fields such as 'name', 'description', 'price', and 'imageSource'.
 *
 * The '@Entity' annotation indicates that instances of this class can be stored in the database.
 * The '@AllArgsConstructor' and '@NoArgsConstructor' annotations are Lombok-generated and provide constructors for all fields
 * and a default constructor respectively.
 * The '@Data' annotation generates boilerplate code for getters, setters, equals, hashCode, and toString methods.
 * Ensure Lombok is properly configured in the project to leverage its features.
 *
 * This class inherits the common indexing fields, such as 'id' and 'createdAt', from its superclass ImmutableIdEntity.
 * The 'id' field is immutable, and any attempt to modify it will result in an UnalterableException being thrown.
 * @author [mariohieu09]
 * @since [9/1/2024]
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Product extends ImmutableIdEntity {


    /**
     * The name of the product.
     */
    @NotNull
    @NotBlank
    @Size(max = 20, message = "The product's name must not over 20 character long!")
    private String name;
    /**
     * The description of the product
     */
    @Size(max = 150, message = "The product's description must not over 150 character long!")
    private String description;
    /**
     * The price of the product
     */
    @Max(value = 1000000, message = "Product price must not get over 1 mil $!")
    private double price;
    /**
     * The source of product's image
     */
    private String imageSource;


}
