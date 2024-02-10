package com.example.stewie.entity;

import com.example.stewie.entity.base.ImmutableIdEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRole extends ImmutableIdEntity {
    private String name;

    @ManyToMany
    private Set<Permissions> permissionsSet;

}
