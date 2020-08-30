package io.redintro.hexbike.adapter.in.web.resource;

import java.util.UUID;

public class UserResource {
    private final UUID id;
    private final String username;
    private final String password;
    private final String role;

    public UserResource(UUID id, String username, String password, String role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
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

    public String getRole() {
        return role;
    }
}
