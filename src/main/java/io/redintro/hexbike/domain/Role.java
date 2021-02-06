package io.redintro.hexbike.domain;

import org.immutables.value.Value;

import java.util.UUID;

@Value.Immutable(builder = false)
public abstract class Role {
    @Value.Parameter
    public abstract UUID getId();

    @Value.Parameter
    public abstract String getName();

    public static Role getInstance(UUID id, String name) {
        return ImmutableRole.of(id, name);
    }
}
