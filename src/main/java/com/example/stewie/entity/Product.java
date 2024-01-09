package com.example.stewie.entity;

import com.example.stewie.entity.base.ImmutableIdEntity;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
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
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Product extends ImmutableIdEntity {


    /**
     * The name of the product.
     */
    private String name;
    /**
     * The description of the product
     */
    private String description;
    /**
     * The price of the product
     */
    private double price;
    /**
     * The source of product's image
     */
    private String imageSource;


}
