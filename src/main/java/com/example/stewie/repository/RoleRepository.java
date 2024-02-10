package com.example.stewie.repository;

import com.example.stewie.entity.UserRole;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface RoleRepository extends BaseRepository<UserRole>{

    Optional<UserRole> findByName(String name);

}
