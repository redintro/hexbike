package io.redintro.hexbike.adapter.in.web.resource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.Test;

class OwnerResourceTest {
  @Test
  public void shouldCreateOwnerResource() {
    UUID ownerId = UUID.randomUUID();
    UUID bikeId = UUID.randomUUID();

    OwnerResource ownerResource =
        new OwnerResource(
            ownerId,
            "Jeff",
            "Jefferson",
            List.of(
                new BikeResource(bikeId, ownerId, "Cinelli", "Vigorelli", "White", 2017, 1249)));

    assertThat(ownerResource.getId(), is(equalTo(ownerId)));
    assertThat(ownerResource.getFirstName(), is(equalTo("Jeff")));
    assertThat(ownerResource.getLastName(), is(equalTo("Jefferson")));
    assertThat(ownerResource.getBikeResources().size(), is(equalTo(1)));
  }
}
