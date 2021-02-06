package io.redintro.hexbike.domain;

import org.immutables.value.Value;

import java.util.List;
import java.util.UUID;

@Value.Immutable(builder = false)
public abstract class Owner {
    @Value.Parameter
    public abstract UUID getId();

    @Value.Parameter
    public abstract String getFirstName();

    @Value.Parameter
    public abstract String getLastName();

    @Value.Parameter
    public abstract List<Bike> getBikes();

    public static Owner getInstance(UUID id, String firstName, String lastName, List<Bike> bikes) {
        return ImmutableOwner.of(id, firstName, lastName, bikes);
    }
}
