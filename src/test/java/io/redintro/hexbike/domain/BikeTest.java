package io.redintro.hexbike.domain;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import java.util.UUID;
import org.junit.jupiter.api.Test;

class BikeTest {
  @Test
  public void shouldCreateBike() {
    UUID bikeId = UUID.randomUUID();
    UUID ownerId = UUID.randomUUID();

    Bike bike = Bike.getInstance(bikeId, ownerId, "Cinelli", "Vigorelli", "White", 2017, 1249);

    assertThat(bike.getId(), is(equalTo(bikeId)));
    assertThat(bike.getOwnerId(), is(equalTo(ownerId)));
    assertThat(bike.getMake(), is(equalTo("Cinelli")));
    assertThat(bike.getModel(), is(equalTo("Vigorelli")));
    assertThat(bike.getColour(), is(equalTo("White")));
    assertThat(bike.getYear(), is(equalTo(2017)));
    assertThat(bike.getPrice(), is(equalTo(1249)));
  }
}
