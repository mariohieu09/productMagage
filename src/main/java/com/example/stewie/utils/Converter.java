package com.example.stewie.utils;

import com.example.stewie.dto.base.BaseDto;
import com.example.stewie.entity.base.IndexableEntity;
import org.springframework.stereotype.Component;

/**
 * This class convert from dto to entity and convert back
 *
 * @param <D> The request data transfer object, it must extend BaseDto
 * @param <E> The Entity, it must extend IndexableEntity
 * @param <R> The response data transfer object, it must extend BaseDto
 */
@Component
public abstract class Converter<D extends BaseDto, E extends IndexableEntity, R extends BaseDto> {
    /**
     * This method convert from request data transfer object to entity
     *
     * @param dto The request data transfer object
     * @return An instance of the entity
     */
     public abstract E convertToEntity(D dto);

    /**
     * This method convert from entity to response data transfer object
     *
     * @param entity The entity you want to convert
     * @return An instance of response data transfer object
     */
    public abstract R convertToDto(E entity);
}
