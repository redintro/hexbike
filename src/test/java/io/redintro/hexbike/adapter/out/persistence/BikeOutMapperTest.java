package io.redintro.hexbike.adapter.out.persistence;

import io.redintro.hexbike.domain.Bike;
import io.redintro.hexbike.domain.Owner;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class BikeOutMapperTest {
    @Test
    public void shouldCreateBikeOutMapper() {
        BikeOutMapper bikeOutMapper = new BikeOutMapper();
        assertThat(bikeOutMapper, is(notNullValue()));
    }

    @Test
    public void shouldMapToDomainEntity() {
        BikeJpaEntity bikeJpaEntity = new BikeJpaEntity(1L, "Cinelli", "Vigorelli", "White",
                2017, 1249, new OwnerJpaEntity(1L,"Jeff", "Jefferson"));

        Bike bike = BikeOutMapper.mapToDomainEntity(bikeJpaEntity);

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
    public void shouldMapToJpaEntity() {
        Bike bike = new Bike(1L, "Cinelli", "Vigorelli", "White", 2017,
                1249, new Owner(1L, "Jeff", "Jefferson"));

        BikeJpaEntity bikeJpaEntity = BikeOutMapper.mapToJpaEntity(bike);

        assertThat(bikeJpaEntity.getId(), is(equalTo(1L)));
        assertThat(bikeJpaEntity.getMake(), is(equalTo("Cinelli")));
        assertThat(bikeJpaEntity.getModel(), is(equalTo("Vigorelli")));
        assertThat(bikeJpaEntity.getColour(), is(equalTo("White")));
        assertThat(bikeJpaEntity.getYear(), is(equalTo(2017)));
        assertThat(bikeJpaEntity.getPrice(), is(equalTo(1249)));
        assertThat(bikeJpaEntity.getOwner().getId(), is(equalTo(1L)));
        assertThat(bikeJpaEntity.getOwner().getFirstName(), is(equalTo("Jeff")));
        assertThat(bikeJpaEntity.getOwner().getLastName(), is(equalTo("Jefferson")));
    }
}