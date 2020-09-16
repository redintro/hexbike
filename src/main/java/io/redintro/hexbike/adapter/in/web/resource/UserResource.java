package io.redintro.hexbike.adapter.in.web.resource;

import java.util.Set;
import java.util.UUID;

public class UserResource {
    private final UUID id;
    private final String username;
    private final String password;
    private final Set<RoleResource> roles;

    public UserResource(UUID id, String username, String password, Set<RoleResource> roles) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    public UUID getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Set<RoleResource> getRoles() {
        return roles;
    }
}
