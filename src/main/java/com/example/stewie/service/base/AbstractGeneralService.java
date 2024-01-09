package com.example.stewie.service.base;

import com.example.stewie.dto.base.BaseDto;
import com.example.stewie.entity.base.IndexableEntity;
import com.example.stewie.exception.NotFoundException;
import com.example.stewie.repository.BaseRepository;
import com.example.stewie.utils.Converter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public abstract class AbstractGeneralService<D extends BaseDto, E extends IndexableEntity, R extends BaseDto> extends Converter<D, E, R> implements IGeneralService<D, E, R> {
    private final BaseRepository<E> entityRepository;

    @Override
    public List<R> getAll() {
        return entityRepository.findAll()
                .stream()
                .map(this::convertToDto)
                .toList();
    }

    @Override
    public R getById(Long id) {
        Optional<E> entityOptional = entityRepository.findById(id);
        if(entityOptional.isEmpty()){
            throw new NotFoundException();
        }
        return this.convertToDto(entityOptional.get());
    }

    @Override
    public R save(D dto) {
        E entity = this.convertToEntity(dto);
        entityRepository.save(entity);
        return this.convertToDto(entity);
    }

    @Override
    public void delete(D dto) {
        entityRepository.delete(this.convertToEntity(dto));
    }

    @Override
    public void deleteById(Long id) {
        entityRepository.deleteById(id);
    }

}
