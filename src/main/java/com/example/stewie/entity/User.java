package com.example.stewie.entity;

import com.example.stewie.entity.base.ImmutableIdEntity;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * An entity class representing a user with an immutable identifier.
 * Each user has a unique identifier ('id') and includes additional fields such as 'username' and 'encoderString'.
 *
 * The '@Entity' annotation indicates that instances of this class can be stored in the database.
 * The '@Data' annotation is Lombok-generated and provides boilerplate code for getters, setters, equals, hashCode, and toString methods.
 * The '@AllArgsConstructor' and '@NoArgsConstructor' annotations are Lombok-generated and provide constructors for all fields
 * and a default constructor respectively.
 * The '@Builder' annotation is Lombok-generated and allows for the convenient creation of builder patterns.
 * Ensure Lombok is properly configured in the project to leverage its features.
 *
 * This class inherits the common indexing fields, such as 'id' and 'createdAt', from its superclass ImmutableIdEntity.
 * The 'id' field is immutable, and any attempt to modify it will result in an UnalterableException being thrown.
 *
 * Fields:
 * - 'username': The unique username associated with the user.
 * - 'encoderString': The encoded string representation associated with the user.
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User extends ImmutableIdEntity {

    /**
     * The unique username associated with the user.
     */
    private String username;

    /**
     * The encoded string representation associated with the user.
     */
    private String encoderString;


}
