package io.redintro.hexbike.adapter.in.web.resource;

import java.util.Set;
import java.util.UUID;

public class UserResource {
    private final UUID id;
    private final String username;
    private final String password;
    private final Set<AuthorityResource> authorities;

    public UserResource(UUID id, String username, String password, Set<AuthorityResource> authorities) {
        this.id = id;
        this.username = username;
        this.password = password;
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

    public Set<AuthorityResource> getAuthorities() {
        return authorities;
    }
}
