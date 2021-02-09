package io.redintro.hexbike.adapter.out.persistence.entity;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import java.util.UUID;
import org.junit.jupiter.api.Test;

class BikeJpaEntityTest {
  @Test
  public void shouldCreateBikeJpaEntity() {
    final UUID bikeId = UUID.fromString("11edf58d-0d27-470f-a527-3bab79ba5576");
    final UUID ownerId = UUID.fromString("40b8098d-8058-465e-acff-ac1119e57b27");

    BikeJpaEntity bikeJpaEntity =
        new BikeJpaEntity(
            bikeId,
            "Cinelli",
            "Vigorelli",
            "White",
            2017,
            1249,
            new OwnerJpaEntity(ownerId, "Jeff", "Jefferson"));

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
