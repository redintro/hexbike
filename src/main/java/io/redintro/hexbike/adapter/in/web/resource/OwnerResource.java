package io.redintro.hexbike.adapter.in.web.resource;

import java.util.List;
import java.util.UUID;

public class OwnerResource {
    private final UUID id;
    private final String firstName;
    private final String lastName;
    private final List<BikeResource> bikeResources;

    public OwnerResource(UUID id, String firstName, String lastName, List<BikeResource> bikeResources) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.bikeResources = bikeResources;
    }

    public UUID getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public List<BikeResource> getBikeResources() {
        return bikeResources;
    }
}
