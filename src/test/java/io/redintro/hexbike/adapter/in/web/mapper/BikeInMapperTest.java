package io.redintro.hexbike.adapter.in.web.mapper;

import io.redintro.hexbike.adapter.in.web.resource.BikeResource;
import io.redintro.hexbike.adapter.in.web.resource.OwnerResource;
import io.redintro.hexbike.domain.Bike;
import io.redintro.hexbike.domain.Owner;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

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
        UUID bikeId = UUID.randomUUID();
        UUID ownerId = UUID.randomUUID();

        BikeResource bikeResource = new BikeResource(bikeId, "Cinelli", "Vigorelli", "White",
                2017, 1249, new OwnerResource(ownerId,"Jeff", "Jefferson"));

        Optional<Bike> bike = BikeInMapper.mapToDomainEntity(bikeResource);

        assertThat(bike.isPresent(), is(equalTo(true)));
        assertThat(bike.get().getId(), is(equalTo(bikeId)));
        assertThat(bike.get().getMake(), is(equalTo("Cinelli")));
        assertThat(bike.get().getModel(), is(equalTo("Vigorelli")));
        assertThat(bike.get().getColour(), is(equalTo("White")));
        assertThat(bike.get().getYear(), is(equalTo(2017)));
        assertThat(bike.get().getPrice(), is(equalTo(1249)));
        assertThat(bike.get().getOwner().getId(), is(equalTo(ownerId)));
        assertThat(bike.get().getOwner().getFirstName(), is(equalTo("Jeff")));
        assertThat(bike.get().getOwner().getLastName(), is(equalTo("Jefferson")));
    }

    @Test
    public void shouldMapToRestResource() {
        UUID bikeId = UUID.randomUUID();
        UUID ownerId = UUID.randomUUID();

        Bike bike = Bike.getInstance(bikeId, "Cinelli", "Vigorelli", "White", 2017,
                1249, Owner.getInstance(ownerId, "Jeff", "Jefferson"));

        Optional<BikeResource> bikeResource = BikeInMapper.mapToRestResource(bike);

        assertThat(bikeResource.isPresent(), is(equalTo(true)));
        assertThat(bikeResource.get().getId(), is(equalTo(bikeId)));
        assertThat(bikeResource.get().getMake(), is(equalTo("Cinelli")));
        assertThat(bikeResource.get().getModel(), is(equalTo("Vigorelli")));
        assertThat(bikeResource.get().getColour(), is(equalTo("White")));
        assertThat(bikeResource.get().getYear(), is(equalTo(2017)));
        assertThat(bikeResource.get().getPrice(), is(equalTo(1249)));
        assertThat(bikeResource.get().getOwner().getId(), is(equalTo(ownerId)));
        assertThat(bikeResource.get().getOwner().getFirstName(), is(equalTo("Jeff")));
        assertThat(bikeResource.get().getOwner().getLastName(), is(equalTo("Jefferson")));
    }

    @Test
    public void shouldMapToListOfRestResource() {
        UUID bikeId = UUID.randomUUID();
        UUID ownerId = UUID.randomUUID();

        List<Bike> bikes = List.of(Bike.getInstance(bikeId, "Cinelli", "Vigorelli", "White", 2017,
                1249, Owner.getInstance(ownerId, "Jeff", "Jefferson")));

        List<BikeResource> bikeResources = BikeInMapper.mapToListRestResource(bikes);

        assertThat(bikeResources.size(), is(equalTo(1)));
    }

    @Test
    public void shouldMapWithNullBikeToListOfRestResource() {
        UUID bikeId = UUID.randomUUID();
        UUID ownerId = UUID.randomUUID();

        Bike bike = Bike.getInstance(bikeId, "Cinelli", "Vigorelli", "White", 2017,
                1249, Owner.getInstance(ownerId, "Jeff", "Jefferson"));

        List<Bike> bikes = new ArrayList<>();
        bikes.add(bike);
        bikes.add(null);

        List<BikeResource> bikeResources = BikeInMapper.mapToListRestResource(bikes);

        assertThat(bikeResources.size(), is(equalTo(1)));
    }

    @Test
    public void shouldMapToEmptyListOfRestResource() {
        List<BikeResource> bikeResources = BikeInMapper.mapToListRestResource(null);

        assertThat(bikeResources.size(), is(equalTo(0)));
    }
}