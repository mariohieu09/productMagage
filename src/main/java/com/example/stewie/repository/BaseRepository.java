package com.example.stewie.repository;

import com.example.stewie.entity.base.IndexableEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BaseRepository<T extends IndexableEntity> extends JpaRepository<T, Long> {
}
