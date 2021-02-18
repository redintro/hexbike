package io.redintro.hexbike.adapter.out.persistence.entity;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.UUID;
import org.junit.jupiter.api.Test;

class OwnerJpaEntityTest {
  @Test
  public void shouldCreateOwnerJpaEntity() {
    final UUID ownerId = UUID.fromString("40b8098d-8058-465e-acff-ac1119e57b27");
    final String firstName = "Jeff";
    final String lastName = "Jefferson";
    final AddressJpaEntity address = new AddressJpaEntity("Address 1", "Address 2");

    OwnerJpaEntity ownerJpaEntity = new OwnerJpaEntity(ownerId, firstName, lastName, address);

    assertThat(ownerJpaEntity.getId(), is(equalTo(ownerId)));
    assertThat(ownerJpaEntity.getFirstName(), is(equalTo("Jeff")));
    assertThat(ownerJpaEntity.getLastName(), is(equalTo("Jefferson")));
    assertThat(ownerJpaEntity.getAddress(), is(equalTo(address)));
  }
}
