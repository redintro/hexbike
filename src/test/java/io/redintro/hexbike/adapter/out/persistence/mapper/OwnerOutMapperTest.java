package io.redintro.hexbike.adapter.out.persistence.mapper;

import io.redintro.hexbike.adapter.out.persistence.entity.OwnerJpaEntity;
import io.redintro.hexbike.domain.Owner;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.UUID;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class OwnerOutMapperTest {
    @Test
    public void shouldCreateOwnerOutMapper() {
        OwnerOutMapper ownerOutMapper = new OwnerOutMapper();
        assertThat(ownerOutMapper, is(notNullValue()));
    }

    @Test
    public void shouldMapToDomainEntity() {
        UUID ownerId = UUID.randomUUID();

        OwnerJpaEntity ownerJpaEntity = new OwnerJpaEntity(ownerId, "Jeff", "Jefferson", List.of());

        Owner owner = OwnerOutMapper.mapToDomainEntity(ownerJpaEntity);

        assertThat(owner.getId(), is(equalTo(ownerId)));
        assertThat(owner.getFirstName(), is(equalTo("Jeff")));
        assertThat(owner.getLastName(), is(equalTo("Jefferson")));
    }
}