package io.redintro.hexbike.domain;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import java.util.UUID;
import org.junit.jupiter.api.Test;

class OwnerTest {
  @Test
  public void shouldCreateOwner() {
    final UUID ownerId = UUID.fromString("40b8098d-8058-465e-acff-ac1119e57b27");
    final Owner owner = Owner.getInstance(ownerId, "Jeff", "Jefferson");

    assertThat(owner.getId(), is(equalTo(ownerId)));
    assertThat(owner.getFirstName(), is(equalTo("Jeff")));
    assertThat(owner.getLastName(), is(equalTo("Jefferson")));
  }
}
