package io.redintro.hexbike.domain;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.UUID;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

class OwnerTest {
    @Test
    public void shouldCreateOwner() {
        UUID ownerId = UUID.randomUUID();
        UUID bikeId = UUID.randomUUID();

        Owner owner = Owner.getInstance(ownerId, "Jeff", "Jefferson",
                List.of(Bike.getInstance(bikeId, ownerId, "Cinelli", "Vigorelli", "White", 2017,
                1249)));

        assertThat(owner.getId(), is(equalTo(ownerId)));
        assertThat(owner.getFirstName(), is(equalTo("Jeff")));
        assertThat(owner.getLastName(), is(equalTo("Jefferson")));
        assertThat(owner.getBikes().size(), is(1));
    }
}