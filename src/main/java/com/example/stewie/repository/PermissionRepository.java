package com.example.stewie.repository;

import com.example.stewie.entity.Permissions;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PermissionRepository extends BaseRepository<Permissions> {

    Optional<Permissions> findByEndpoint(String endpoint);

    Optional<Permissions> findByName(String name);
}
