package io.redintro.hexbike.adapter.out.persistence.mapper;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import io.redintro.hexbike.adapter.out.persistence.entity.OwnerJpaEntity;
import io.redintro.hexbike.domain.Owner;
import java.util.UUID;
import org.junit.jupiter.api.Test;

class OwnerOutMapperTest {
  @Test
  public void shouldCreateOwnerOutMapper() {
    OwnerOutMapper ownerOutMapper = new OwnerOutMapper();
    assertThat(ownerOutMapper, is(notNullValue()));
  }

  @Test
  public void shouldMapToDomainEntity() {
    final UUID ownerId = UUID.fromString("40b8098d-8058-465e-acff-ac1119e57b27");

    OwnerJpaEntity ownerJpaEntity = new OwnerJpaEntity(ownerId, "Jeff", "Jefferson");

    Owner owner = OwnerOutMapper.mapToDomainEntity(ownerJpaEntity);

    assertThat(owner.getId(), is(equalTo(ownerId)));
    assertThat(owner.getFirstName(), is(equalTo("Jeff")));
    assertThat(owner.getLastName(), is(equalTo("Jefferson")));
  }
}
