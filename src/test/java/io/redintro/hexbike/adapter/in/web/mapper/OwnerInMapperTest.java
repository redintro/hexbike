package io.redintro.hexbike.adapter.in.web.mapper;

import io.redintro.hexbike.adapter.in.web.resource.OwnerResource;
import io.redintro.hexbike.domain.Owner;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class OwnerInMapperTest {
    @Test
    public void shouldCreateOwnerMapper() {
        OwnerInMapper ownerInMapper = new OwnerInMapper();
        assertThat(ownerInMapper, is(notNullValue()));
    }

    @Test
    public void shouldMapToDomainEntity() {
        OwnerResource ownerResource = new OwnerResource(1L, "Jeff", "Jefferson");

        Owner owner = OwnerInMapper.mapToDomainEntity(ownerResource);

        assertThat(owner.getId(), is(equalTo(1L)));
        assertThat(owner.getFirstName(), is(equalTo("Jeff")));
        assertThat(owner.getLastName(), is(equalTo("Jefferson")));
    }

    @Test
    public void shouldMapToResource() {
        Owner owner = new Owner(1L, "Jeff", "Jefferson");

        OwnerResource ownerResource = OwnerInMapper.mapToResource(owner);

        assertThat(ownerResource.getId(), is(equalTo(1L)));
        assertThat(ownerResource.getFirstName(), is(equalTo("Jeff")));
        assertThat(ownerResource.getLastName(), is(equalTo("Jefferson")));
    }
}