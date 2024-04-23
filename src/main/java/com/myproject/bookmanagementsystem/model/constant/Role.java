package com.myproject.bookmanagementsystem.model.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collections;
import java.util.List;
import java.util.Set;

@Getter
@RequiredArgsConstructor
public enum Role {

    USER(Collections.emptySet()),

    ADMIN(
            Set.of(
                    Permission.ADMIN_READ,
                    Permission.ADMIN_UPDATE,
                    Permission.ADMIN_DELETE,
                    Permission.ADMIN_CREATE,

                    Permission.MANAGER_READ,
                    Permission.MANAGER_UPDATE,
                    Permission.MANAGER_DELETE,
                    Permission.MANAGER_CREATE,

                    Permission.AUTHOR_READ,
                    Permission.AUTHOR_UPDATE,
                    Permission.AUTHOR_DELETE,
                    Permission.AUTHOR_CREATE
            )
    ),
    MANAGER(
            Set.of(
                    Permission.MANAGER_READ,
                    Permission.MANAGER_UPDATE,
                    Permission.MANAGER_DELETE,
                    Permission.MANAGER_CREATE
            )
    ),
    AUTHOR(
            Set.of(
                    Permission.AUTHOR_READ,
                    Permission.AUTHOR_UPDATE,
                    Permission.AUTHOR_DELETE,
                    Permission.AUTHOR_CREATE
            )
    );

    private final Set<Permission> permissions;

    public List<SimpleGrantedAuthority> getAuthorities() {
        var authorities = new java.util.ArrayList<>(getPermissions()
                .stream()
                .map(
                        permission -> new SimpleGrantedAuthority(permission.getPermission())
                )
                .toList());
        authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return authorities;
    }
}
