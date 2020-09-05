package io.redintro.hexbike.adapter.in.web.mapper;

import io.redintro.hexbike.adapter.in.web.resource.OwnerResource;
import io.redintro.hexbike.domain.Owner;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class OwnerInMapperTest {
    private UUID ownerId = UUID.randomUUID();
    private Owner owner = new Owner(ownerId, "Jeff", "Jefferson");

    @Test
    public void shouldCreateOwnerMapper() {
        OwnerInMapper ownerInMapper = new OwnerInMapper();
        assertThat(ownerInMapper, is(notNullValue()));
    }

    @Test
    public void shouldMapToDomainEntity() {
        UUID ownerId = UUID.randomUUID();

        OwnerResource ownerResource = new OwnerResource(ownerId, "Jeff", "Jefferson");

        Owner owner = OwnerInMapper.mapToDomainEntity(ownerResource);

        assertThat(owner.getId(), is(equalTo(ownerId)));
        assertThat(owner.getFirstName(), is(equalTo("Jeff")));
        assertThat(owner.getLastName(), is(equalTo("Jefferson")));
    }

    @Test
    public void shouldMapToResource() {
        Optional<OwnerResource> ownerResource = OwnerInMapper.mapToResource(owner);

        assertThat(ownerResource.isPresent(), is(equalTo(true)));
        assertThat(ownerResource.get().getId(), is(equalTo(ownerId)));
        assertThat(ownerResource.get().getFirstName(), is(equalTo("Jeff")));
        assertThat(ownerResource.get().getLastName(), is(equalTo("Jefferson")));
    }

    @Test
    public void shouldMapToEmpty() {
        assertThat(OwnerInMapper.mapToResource(null).isEmpty(), is(true));
    }

    @Test
    public void shouldMapListToResource() {
        List<OwnerResource> ownerResources = OwnerInMapper.mapToListResource(List.of(owner));
        assertThat(ownerResources.size(), is(1));
    }
}