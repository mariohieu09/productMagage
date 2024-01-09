package com.example.stewie.service.base;

import org.springframework.stereotype.Service;

import java.util.List;


public interface IGeneralService <D, E, R>{
    List<R> getAll();

    R getById(Long id);

    R save (D dto);

    void delete(D dto);

    void deleteById(Long id);
}
