package io.redintro.hexbike.adapter.out.persistence.entity;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.Test;

class BikeJpaEntityTest {
  @Test
  public void shouldCreateBikeJpaEntity() {
    UUID bikeId = UUID.randomUUID();
    UUID ownerId = UUID.randomUUID();

    BikeJpaEntity bikeJpaEntity =
        new BikeJpaEntity(
            bikeId,
            "Cinelli",
            "Vigorelli",
            "White",
            2017,
            1249,
            new OwnerJpaEntity(ownerId, "Jeff", "Jefferson", List.of()));

    assertThat(bikeJpaEntity.getId(), is(equalTo(bikeId)));
    assertThat(bikeJpaEntity.getMake(), is(equalTo("Cinelli")));
    assertThat(bikeJpaEntity.getModel(), is(equalTo("Vigorelli")));
    assertThat(bikeJpaEntity.getColour(), is(equalTo("White")));
    assertThat(bikeJpaEntity.getYear(), is(equalTo(2017)));
    assertThat(bikeJpaEntity.getPrice(), is(equalTo(1249)));
    assertThat(bikeJpaEntity.getOwner().getId(), is(equalTo(ownerId)));
    assertThat(bikeJpaEntity.getOwner().getFirstName(), is(equalTo("Jeff")));
    assertThat(bikeJpaEntity.getOwner().getLastName(), is(equalTo("Jefferson")));
  }
}
