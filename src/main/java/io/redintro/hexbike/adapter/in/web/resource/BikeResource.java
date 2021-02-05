package io.redintro.hexbike.adapter.in.web.resource;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

public class BikeResource {
    private final UUID id;
    private final UUID ownerId;
    @NotBlank(message = "Make cannot be blank")
    private final String make;
    private final String model;
    private final String colour;
    private final int year;
    private final int price;

    public BikeResource(UUID id, UUID ownerId, String make, String model, String colour, int year, int price) {
        this.id = id;
        this.ownerId = ownerId;
        this.make = make;
        this.model = model;
        this.colour = colour;
        this.year = year;
        this.price = price;
    }

    public UUID getId() {
        return id;
    }

    public UUID getOwnerId() {
        return ownerId;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public String getColour() {
        return colour;
    }

    public int getYear() {
        return year;
    }

    public int getPrice() {
        return price;
    }
}