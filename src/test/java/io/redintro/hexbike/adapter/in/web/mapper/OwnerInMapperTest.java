package io.redintro.hexbike.adapter.in.web.mapper;

import io.redintro.hexbike.adapter.in.web.resource.BikeResource;
import io.redintro.hexbike.adapter.in.web.resource.OwnerResource;
import io.redintro.hexbike.domain.Bike;
import io.redintro.hexbike.domain.Owner;
import io.vavr.control.Option;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.UUID;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class OwnerInMapperTest {
    private final UUID ownerId = UUID.randomUUID();
    private final UUID bikeId = UUID.randomUUID();
    private final Owner owner = Owner.getInstance(ownerId, "Jeff", "Jefferson",
            List.of(Bike.getInstance(bikeId, ownerId, "Cinelli", "Vigorelli", "White", 2017,
            1249)));

    @Test
    public void shouldCreateOwnerMapper() {
        assertThat(new OwnerInMapper(), is(notNullValue()));
    }

    @Test
    public void shouldMapToDomainEntity() {
        OwnerResource ownerResource = new OwnerResource(ownerId, "Jeff", "Jefferson",
                List.of(new BikeResource(bikeId, ownerId, "Cinelli", "Vigorelli", "White", 2017,
                1249)));

        Option<Owner> owner = OwnerInMapper.mapToDomainEntity(ownerResource);

        assertThat(owner.isDefined(), is(equalTo(true)));
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
        Option<OwnerResource> ownerResource = OwnerInMapper.mapToRestResource(owner);

        assertThat(ownerResource.isDefined(), is(equalTo(true)));
        assertThat(ownerResource.get().getId(), is(equalTo(ownerId)));
        assertThat(ownerResource.get().getFirstName(), is(equalTo("Jeff")));
        assertThat(ownerResource.get().getLastName(), is(equalTo("Jefferson")));
    }

    @Test
    public void shouldMapToEmptyResource() {
        assertThat(OwnerInMapper.mapToRestResource(null).isEmpty(), is(true));
    }

    @Test
    public void shouldMapToListToResource() {
        List<OwnerResource> ownerResources = OwnerInMapper.mapToListRestResource(List.of(owner));
        assertThat(ownerResources.size(), is(1));
    }
}