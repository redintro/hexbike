package io.redintro.hexbike.adapter.in.web.resource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import java.util.UUID;
import org.junit.jupiter.api.Test;

class BikeResourceTest {
  @Test
  public void shouldCreateBikeResource() {
    UUID bikeId = UUID.randomUUID();
    UUID ownerId = UUID.randomUUID();

    BikeResource bikeResource =
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
