package com.example.stewie.entity.base;

import com.example.stewie.exception.UnalterableException;
/**
 * A specialized entity class extending IndexableEntity with an immutable identifier.
 * Instances of this class cannot have their 'id' field modified once set, enforcing immutability.
 * It throws an UnalterableException if an attempt is made to change the identifier.
 *
 * This class inherits the common indexing fields, such as 'id' and 'createdAt', from its superclass IndexableEntity.
 * The '@MappedSuperclass' annotation on IndexableEntity indicates that it is not mapped to its own database table,
 * but its fields are included in the mapping of its subclasses.
 * @author [mariohieu09]
 * @since [9/1/2024]
 */
public class ImmutableIdEntity extends IndexableEntity {

    /**
     * Overrides the setId method from the superclass to throw an UnalterableException.
     * This enforces the immutability of the 'id' field in instances of this class.
     *
     * @param id The unique identifier to be set (ignored, as the 'id' is immutable).
     * @throws UnalterableException Thrown when an attempt is made to change the identifier, as it is not allowed.
     */
    @Override
    public void setId(Long id) {
        throw new UnalterableException();
    }
}
