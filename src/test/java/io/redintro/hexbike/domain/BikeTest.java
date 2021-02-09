package io.redintro.hexbike.domain;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import java.util.UUID;
import org.junit.jupiter.api.Test;

class BikeTest {
  @Test
  public void shouldCreateBike() {
    final UUID bikeId = UUID.fromString("11edf58d-0d27-470f-a527-3bab79ba5576");
    final UUID ownerId = UUID.fromString("40b8098d-8058-465e-acff-ac1119e57b27");

    final Bike bike =
        Bike.getInstance(bikeId, ownerId, "Cinelli", "Vigorelli", "White", 2017, 1249);

    assertThat(bike.getId(), is(equalTo(bikeId)));
    assertThat(bike.getOwnerId(), is(equalTo(ownerId)));
    assertThat(bike.getMake(), is(equalTo("Cinelli")));
    assertThat(bike.getModel(), is(equalTo("Vigorelli")));
    assertThat(bike.getColour(), is(equalTo("White")));
    assertThat(bike.getYear(), is(equalTo(2017)));
    assertThat(bike.getPrice(), is(equalTo(1249)));
  }
}
