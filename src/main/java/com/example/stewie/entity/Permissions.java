package com.example.stewie.entity;

import com.example.stewie.entity.base.ImmutableIdEntity;
import com.example.stewie.entity.base.IndexableEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.management.relation.Role;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Permissions extends ImmutableIdEntity{

    private String endpoint;

    private String name;

}
