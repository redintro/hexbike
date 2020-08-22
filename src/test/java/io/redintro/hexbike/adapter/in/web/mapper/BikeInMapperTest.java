package io.redintro.hexbike.adapter.in.web.mapper;

import io.redintro.hexbike.adapter.in.web.resource.BikeResource;
import io.redintro.hexbike.adapter.in.web.resource.OwnerResource;
import io.redintro.hexbike.domain.Bike;
import io.redintro.hexbike.domain.Owner;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class BikeInMapperTest {
    @Test
    public void shouldCreateBikeInMapper() {
        BikeInMapper bikeInMapper = new BikeInMapper();
        assertThat(bikeInMapper, is(notNullValue()));
    }

    @Test
    public void shouldMapToDomainEntity() {
        BikeResource bikeResource = new BikeResource(1L, "Cinelli", "Vigorelli", "White",
                2017, 1249, new OwnerResource(1L,"Jeff", "Jefferson"));

        Bike bike = BikeInMapper.mapToDomainEntity(bikeResource);

        assertThat(bike.getId(), is(equalTo(1L)));
        assertThat(bike.getMake(), is(equalTo("Cinelli")));
        assertThat(bike.getModel(), is(equalTo("Vigorelli")));
        assertThat(bike.getColour(), is(equalTo("White")));
        assertThat(bike.getYear(), is(equalTo(2017)));
        assertThat(bike.getPrice(), is(equalTo(1249)));
        assertThat(bike.getOwner().getId(), is(equalTo(1L)));
        assertThat(bike.getOwner().getFirstName(), is(equalTo("Jeff")));
        assertThat(bike.getOwner().getLastName(), is(equalTo("Jefferson")));
    }

    @Test
    public void shouldMapToResource() {
        Bike bike = new Bike(1L, "Cinelli", "Vigorelli", "White", 2017,
                1249, new Owner(1L, "Jeff", "Jefferson"));

        BikeResource bikeResource = BikeInMapper.mapToResource(bike);

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