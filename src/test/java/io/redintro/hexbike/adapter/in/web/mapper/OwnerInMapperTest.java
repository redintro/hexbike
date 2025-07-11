package io.redintro.hexbike.adapter.in.web.mapper;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import io.redintro.hexbike.adapter.in.web.resource.OwnerResource;
import io.redintro.hexbike.domain.Owner;
import io.vavr.control.Option;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.Test;

class OwnerInMapperTest {
  private final UUID ownerId = UUID.fromString("40b8098d-8058-465e-acff-ac1119e57b27");
  private final Owner owner = Owner.getInstance(ownerId, "Jeff", "Jefferson");

  @Test
  public void shouldCreateOwnerMapper() {
    assertThat(new OwnerInMapper(), is(notNullValue()));
  }

  @Test
  public void shouldMapToDomainEntity() {
    final OwnerResource ownerResource = new OwnerResource(ownerId, "Jeff", "Jefferson");

    final Option<Owner> owner = OwnerInMapper.mapToDomainEntity(ownerResource);

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
    final Option<OwnerResource> ownerResource = OwnerInMapper.mapToRestResource(owner);

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
    final List<OwnerResource> ownerResources = OwnerInMapper.mapToListRestResource(List.of(owner));
    assertThat(ownerResources.size(), is(1));
  }
}
