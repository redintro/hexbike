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
    private final UUID ownerId = UUID.randomUUID();
    private final Owner owner = new Owner(ownerId, "Jeff", "Jefferson");

    @Test
    public void shouldCreateOwnerMapper() {
        assertThat(new OwnerInMapper(), is(notNullValue()));
    }

    @Test
    public void shouldMapToDomainEntity() {
        OwnerResource ownerResource = new OwnerResource(ownerId, "Jeff", "Jefferson");

        Optional<Owner> owner = OwnerInMapper.mapToDomainEntity(ownerResource);

        assertThat(owner.isPresent(), is(equalTo(true)));
        assertThat(owner.get().getId(), is(equalTo(ownerId)));
        assertThat(owner.get().getFirstName(), is(equalTo("Jeff")));
        assertThat(owner.get().getLastName(), is(equalTo("Jefferson")));
    }

    @Test
    public void shouldMapToEmptyDomainEntity() {
        assertThat(OwnerInMapper.mapToDomainEntity(null).isEmpty(), is(equalTo(true)));
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
    public void shouldMapToEmptyResource() {
        assertThat(OwnerInMapper.mapToResource(null).isEmpty(), is(true));
    }

    @Test
    public void shouldMapToListToResource() {
        List<OwnerResource> ownerResources = OwnerInMapper.mapToListResource(List.of(owner));
        assertThat(ownerResources.size(), is(1));
    }
}