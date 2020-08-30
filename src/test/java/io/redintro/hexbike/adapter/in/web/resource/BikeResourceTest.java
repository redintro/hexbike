package io.redintro.hexbike.adapter.in.web.resource;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

class BikeResourceTest {
    @Test
    public void shouldCreateBikeResource() {
        UUID bikeId = UUID.randomUUID();
        UUID ownerId = UUID.randomUUID();

        BikeResource bikeResource = new BikeResource(bikeId, "Cinelli", "Vigorelli", "White", 2017,
                1249, new OwnerResource(ownerId, "Jeff", "Jefferson"));

        assertThat(bikeResource.getId(), is(equalTo(bikeId)));
        assertThat(bikeResource.getMake(), is(equalTo("Cinelli")));
        assertThat(bikeResource.getModel(), is(equalTo("Vigorelli")));
        assertThat(bikeResource.getColour(), is(equalTo("White")));
        assertThat(bikeResource.getYear(), is(equalTo(2017)));
        assertThat(bikeResource.getPrice(), is(equalTo(1249)));
        assertThat(bikeResource.getOwner().getId(), is(equalTo(ownerId)));
        assertThat(bikeResource.getOwner().getFirstName(), is(equalTo("Jeff")));
        assertThat(bikeResource.getOwner().getLastName(), is(equalTo("Jefferson")));
    }
}