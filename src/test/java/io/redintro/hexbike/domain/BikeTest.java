package io.redintro.hexbike.domain;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class BikeTest {
    @Test
    public void shouldCreateBike() {
        UUID bikeId = UUID.randomUUID();
        UUID ownerId = UUID.randomUUID();

        Bike bike = new Bike(bikeId, "Cinelli", "Vigorelli", "White", 2017,
                1249, new Owner(ownerId, "Jeff", "Jefferson"));

        assertThat(bike.getId(), is(equalTo(bikeId)));
        assertThat(bike.getMake(), is(equalTo("Cinelli")));
        assertThat(bike.getModel(), is(equalTo("Vigorelli")));
        assertThat(bike.getColour(), is(equalTo("White")));
        assertThat(bike.getYear(), is(equalTo(2017)));
        assertThat(bike.getPrice(), is(equalTo(1249)));
        assertThat(bike.getOwner().getId(), is(equalTo(ownerId)));
        assertThat(bike.getOwner().getFirstName(), is(equalTo("Jeff")));
        assertThat(bike.getOwner().getLastName(), is(equalTo("Jefferson")));
    }
}