package io.redintro.hexbike.adapter.in.web.resource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import java.util.UUID;
import org.junit.jupiter.api.Test;

class OwnerResourceTest {
  @Test
  public void shouldCreateOwnerResource() {
    UUID ownerId = UUID.randomUUID();

    OwnerResource ownerResource = new OwnerResource(ownerId, "Jeff", "Jefferson");

    assertThat(ownerResource.getId(), is(equalTo(ownerId)));
    assertThat(ownerResource.getFirstName(), is(equalTo("Jeff")));
    assertThat(ownerResource.getLastName(), is(equalTo("Jefferson")));
  }
}
