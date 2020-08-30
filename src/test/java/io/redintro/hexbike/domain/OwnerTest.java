package io.redintro.hexbike.domain;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

class OwnerTest {
    @Test
    public void shouldCreateOwner() {
        UUID ownerId = UUID.randomUUID();

        Owner owner = new Owner(ownerId, "Jeff", "Jefferson");

        assertThat(owner.getId(), is(equalTo(ownerId)));
        assertThat(owner.getFirstName(), is(equalTo("Jeff")));
        assertThat(owner.getLastName(), is(equalTo("Jefferson")));
    }
}