package com.example.stewie.entity.base;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * An abstract class representing an indexable entity in the database.
 * Classes extending this one will inherit common fields for indexing, such as 'id' and 'createdAt'.
 *
 * The '@MappedSuperclass' annotation indicates that this class should not be mapped to its own database table
 * but rather its fields should be included in the mapping of its subclasses.
 *
 * The '@Data' annotation is Lombok-generated and includes boilerplate code for getters, setters, equals, hashCode, and toString.
 * Ensure Lombok is properly configured in the project to leverage its features.
 */
@MappedSuperclass
@Data
public abstract class IndexableEntity {

    /**
     * The unique identifier for the entity.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * The timestamp representing the creation date and time of the entity.
     */
    @Column(name = "created_at")
    private Date createdAt;

}
