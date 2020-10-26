package io.redintro.hexbike.domain;

import io.redintro.hexbike.domain.ImmutableBike;

import org.immutables.value.Value;

import java.util.UUID;

@Value.Immutable
public abstract class Bike {
    @Value.Parameter
    public abstract UUID getId();

    @Value.Parameter
    public abstract String getMake();

    @Value.Parameter
    public abstract String getModel();

    @Value.Parameter
    public abstract String getColour();

    @Value.Parameter
    public abstract int getYear();

    @Value.Parameter
    public abstract int getPrice();

    @Value.Parameter
    public abstract Owner getOwner();

    public static Bike getInstance(UUID id, String make, String model, String colour, int year, int price, Owner owner) {
        return ImmutableBike.of(id, make, model, colour, year, price, owner);
    }
}
