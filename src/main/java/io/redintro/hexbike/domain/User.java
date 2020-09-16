package io.redintro.hexbike.domain;

import java.util.Set;
import java.util.UUID;

public class User {
    private final UUID id;
    private final String username;
    private final String password;
    private final Set<Role> roles;

    public User(UUID id, String username, String password, Set<Role> roles) {
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

    public Set<Role> getRoles() {
        return roles;
    }
}
