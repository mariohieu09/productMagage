package com.example.stewie.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import static com.example.stewie.entity.Permissions.*;

/**
 * This class define role for user
 */
@RequiredArgsConstructor
@Getter
public enum UserRole {

    ADMIN(Set.of(
            VIEW_ALL_USERS,
            UPDATE_USER,
            CREATE_USER,
            DELETE_USER,
            GET_USER
    )),
    USER(Collections.emptySet())

    ;
    /**
     * A set of permission has already defined in every role
     */
    private  final Set<Permissions> permissionsSet;


    public List<GrantedAuthority> getAuthorities(){
        List<GrantedAuthority> authorityList = new ArrayList<>();
        for(Permissions p : permissionsSet){
           authorityList.add(new SimpleGrantedAuthority(p.name()));
        }
        authorityList.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return authorityList;
    }
}
