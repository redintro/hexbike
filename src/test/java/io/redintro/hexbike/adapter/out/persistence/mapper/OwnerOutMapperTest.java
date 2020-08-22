package io.redintro.hexbike.adapter.out.persistence.mapper;

import io.redintro.hexbike.adapter.out.persistence.entity.OwnerJpaEntity;
import io.redintro.hexbike.domain.Owner;
import org.junit.jupiter.api.Test;

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
        OwnerJpaEntity ownerJpaEntity = new OwnerJpaEntity(1L, "Jeff", "Jefferson");

        Owner owner = OwnerOutMapper.mapToDomainEntity(ownerJpaEntity);

        assertThat(owner.getId(), is(equalTo(1L)));
        assertThat(owner.getFirstName(), is(equalTo("Jeff")));
        assertThat(owner.getLastName(), is(equalTo("Jefferson")));
    }

    @Test
    public void shouldMapToJpaEntity() {
        Owner owner = new Owner(1L, "Jeff", "Jefferson");

        OwnerJpaEntity ownerJpaEntity = OwnerOutMapper.mapToJpaEntity(owner);

        assertThat(ownerJpaEntity.getId(), is(equalTo(1L)));
        assertThat(ownerJpaEntity.getFirstName(), is(equalTo("Jeff")));
        assertThat(ownerJpaEntity.getLastName(), is(equalTo("Jefferson")));
    }
}