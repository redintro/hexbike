package io.redintro.hexbike.adapter.in.web.resource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import java.util.UUID;
import org.junit.jupiter.api.Test;

class BikeResourceTest {
  @Test
  public void shouldCreateBikeResource() {
    final UUID bikeId = UUID.fromString("11edf58d-0d27-470f-a527-3bab79ba5576");
    final UUID ownerId = UUID.fromString("40b8098d-8058-465e-acff-ac1119e57b27");

    final BikeResource bikeResource =
        new BikeResource(bikeId, ownerId, "Cinelli", "Vigorelli", "White", 2017, 1249);

    assertThat(bikeResource.getId(), is(equalTo(bikeId)));
    assertThat(bikeResource.getOwnerId(), is(equalTo(ownerId)));
    assertThat(bikeResource.getMake(), is(equalTo("Cinelli")));
    assertThat(bikeResource.getModel(), is(equalTo("Vigorelli")));
    assertThat(bikeResource.getColour(), is(equalTo("White")));
    assertThat(bikeResource.getYear(), is(equalTo(2017)));
    assertThat(bikeResource.getPrice(), is(equalTo(1249)));
  }
}
