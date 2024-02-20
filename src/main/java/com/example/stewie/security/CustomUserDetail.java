package com.example.stewie.security;

import com.example.stewie.constant.RoleConstant;
import com.example.stewie.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CustomUserDetail implements UserDetails {

    private static final String PREFIX_ROLE = "ROLE_";
    private User user;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        String role = this.user.getUserRole().getName();
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        for(RoleConstant roleConstant : RoleConstant.values()){
            if(role.equals(roleConstant.name())){
                Set<GrantedAuthority> grantedAuthoritySet = new HashSet<>(
                        roleConstant.getPermission()
                                .stream()
                                .map(SimpleGrantedAuthority::new)
                                .toList()
                );
                grantedAuthorities.addAll(grantedAuthoritySet);
            }
        }
        grantedAuthorities.addAll(this.user.getExtraPermission().stream()
                .map(s -> new SimpleGrantedAuthority(s.getName()))
                .toList());
        grantedAuthorities.add(new SimpleGrantedAuthority(PREFIX_ROLE + role));
        return grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return user.getEncoderString();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
