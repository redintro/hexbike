package io.redintro.hexbike.domain;

import java.util.Set;
import java.util.UUID;

public class User {
    private final UUID id;
    private final String username;
    private final String password;
    private final String role;
    private final Set<Authority> authorities;

    public User(UUID id, String username, String password, String role, Set<Authority> authorities) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
        this.authorities = authorities;
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

    public Set<Authority> getAuthorities() {
        return authorities;
    }
}
