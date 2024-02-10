package com.example.stewie.repository;

import com.example.stewie.entity.Permissions;

import java.util.Optional;

public interface PermissionRepository extends BaseRepository<Permissions> {

    Optional<Permissions> findByEndpoint(String endpoint);

    Permissions findByName(String name);
}
