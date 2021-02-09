package io.redintro.hexbike.adapter.out.persistence.entity;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.UUID;
import org.junit.jupiter.api.Test;

class OwnerJpaEntityTest {
  @Test
  public void shouldCreateOwnerJpaEntity() {
    UUID ownerId = UUID.randomUUID();

    OwnerJpaEntity ownerJpaEntity = new OwnerJpaEntity(ownerId, "Jeff", "Jefferson");

    assertThat(ownerJpaEntity.getId(), is(equalTo(ownerId)));
    assertThat(ownerJpaEntity.getFirstName(), is(equalTo("Jeff")));
    assertThat(ownerJpaEntity.getLastName(), is(equalTo("Jefferson")));
  }
}
