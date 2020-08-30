package io.redintro.hexbike.domain;

import java.util.UUID;

public class Owner {
    private final UUID id;
    private final String firstName;
    private final String lastName;

    public Owner(UUID id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
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
}
