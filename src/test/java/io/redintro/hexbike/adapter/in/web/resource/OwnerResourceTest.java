package io.redintro.hexbike.adapter.in.web.resource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import java.util.UUID;
import org.junit.jupiter.api.Test;

class OwnerResourceTest {
  @Test
  public void shouldCreateOwnerResource() {
    final UUID ownerId = UUID.fromString("40b8098d-8058-465e-acff-ac1119e57b27");

    final OwnerResource ownerResource = new OwnerResource(ownerId, "Jeff", "Jefferson");

    assertThat(ownerResource.getId(), is(equalTo(ownerId)));
    assertThat(ownerResource.getFirstName(), is(equalTo("Jeff")));
    assertThat(ownerResource.getLastName(), is(equalTo("Jefferson")));
  }
}
