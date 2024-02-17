package com.example.stewie.repository;

import com.example.stewie.entity.Permissions;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PermissionRepository extends JpaRepository<Permissions, Long> {

    Optional<Permissions> findByEndpoint(String endpoint);

    Permissions findByName(String name);
}
