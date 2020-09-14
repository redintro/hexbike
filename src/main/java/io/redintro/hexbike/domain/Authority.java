package io.redintro.hexbike.domain;

import java.util.UUID;

public class Authority {
    private final UUID id;
    private final String name;

    public Authority(UUID id, String name) {
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
