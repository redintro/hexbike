package io.redintro.hexbike.adapter.in.web.resource;

import java.util.UUID;

public class AuthorityResource {
    private final UUID id;
    private final String name;

    public AuthorityResource(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
