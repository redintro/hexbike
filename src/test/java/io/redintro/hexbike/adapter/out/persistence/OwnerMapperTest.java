package io.redintro.hexbike.adapter.out.persistence;

import io.redintro.hexbike.domain.Owner;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class OwnerMapperTest {
    @Test
    public void shouldCreateOwnerMapper() {
        OwnerMapper ownerMapper = new OwnerMapper();
        assertThat(ownerMapper, is(notNullValue()));
    }

    @Test
    public void shouldMapToDomainEntity() {
        OwnerJpaEntity ownerJpaEntity = new OwnerJpaEntity(1L, "Jeff", "Jefferson");

        Owner owner = OwnerMapper.mapToDomainEntity(ownerJpaEntity);

        assertThat(owner.getId(), is(equalTo(1L)));
        assertThat(owner.getFirstName(), is(equalTo("Jeff")));
        assertThat(owner.getLastName(), is(equalTo("Jefferson")));
    }

    @Test
    public void shouldMapToJpaEntity() {
        Owner owner = new Owner(1L, "Jeff", "Jefferson");

        OwnerJpaEntity ownerJpaEntity = OwnerMapper.mapToJpaEntity(owner);

        assertThat(ownerJpaEntity.getId(), is(equalTo(1L)));
        assertThat(ownerJpaEntity.getFirstName(), is(equalTo("Jeff")));
        assertThat(ownerJpaEntity.getLastName(), is(equalTo("Jefferson")));
    }
}