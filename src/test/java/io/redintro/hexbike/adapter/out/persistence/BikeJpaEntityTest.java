package io.redintro.hexbike.adapter.out.persistence;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

class BikeJpaEntityTest {
    @Test
    public void shouldCreateBikeJpaEntity() {
        BikeJpaEntity bikeJpaEntity = new BikeJpaEntity(1L, "Cinelli", "Vigorelli", "White",
                2017, 1249, new OwnerJpaEntity(1L,"Jeff", "Jefferson"));

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