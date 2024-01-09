package com.example.stewie.repository;

import com.example.stewie.entity.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends BaseRepository<User>{

    Optional<User> findUserByUsername(String username);
}
