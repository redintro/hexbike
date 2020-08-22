package io.redintro.hexbike.adapter.in.web.resource;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

class BikeResourceTest {
    @Test
    public void shouldCreateBikeResource() {
        BikeResource bikeResource = new BikeResource(1L, "Cinelli", "Vigorelli", "White", 2017,
                1249, new OwnerResource(1L, "Jeff", "Jefferson"));

        assertThat(bikeResource.getId(), is(equalTo(1L)));
        assertThat(bikeResource.getMake(), is(equalTo("Cinelli")));
        assertThat(bikeResource.getModel(), is(equalTo("Vigorelli")));
        assertThat(bikeResource.getColour(), is(equalTo("White")));
        assertThat(bikeResource.getYear(), is(equalTo(2017)));
        assertThat(bikeResource.getPrice(), is(equalTo(1249)));
        assertThat(bikeResource.getOwner().getId(), is(equalTo(1L)));
        assertThat(bikeResource.getOwner().getFirstName(), is(equalTo("Jeff")));
        assertThat(bikeResource.getOwner().getLastName(), is(equalTo("Jefferson")));
    }
}