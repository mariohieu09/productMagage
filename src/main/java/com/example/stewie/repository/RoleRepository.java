package com.example.stewie.repository;

import com.example.stewie.entity.UserRole;

import java.util.Optional;

public interface RoleRepository extends BaseRepository<UserRole>{

    Optional<UserRole> findByName(String name);

}
