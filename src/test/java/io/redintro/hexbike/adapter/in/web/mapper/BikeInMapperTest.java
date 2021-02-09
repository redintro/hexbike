package io.redintro.hexbike.adapter.in.web.mapper;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import io.redintro.hexbike.adapter.in.web.resource.BikeResource;
import io.redintro.hexbike.domain.Bike;
import io.vavr.control.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.Test;

class BikeInMapperTest {
  @Test
  public void shouldCreateMapper() {
    @SuppressWarnings("InstantiationOfUtilityClass")
    BikeInMapper bikeInMapper = new BikeInMapper();
    assertThat(bikeInMapper, is(notNullValue()));
  }

  @Test
  public void shouldMapToDomainEntity() {
    final UUID bikeId = UUID.fromString("11edf58d-0d27-470f-a527-3bab79ba5576");
    final UUID ownerId = UUID.fromString("40b8098d-8058-465e-acff-ac1119e57b27");

    final BikeResource bikeResource =
        new BikeResource(bikeId, ownerId, "Cinelli", "Vigorelli", "White", 2017, 1249);

    final Option<Bike> bike = BikeInMapper.mapToDomainEntity(bikeResource);

    assertThat(bike.isDefined(), is(equalTo(true)));
    assertThat(bike.get().getId(), is(equalTo(bikeId)));
    assertThat(bike.get().getOwnerId(), is(equalTo(ownerId)));
    assertThat(bike.get().getMake(), is(equalTo("Cinelli")));
    assertThat(bike.get().getModel(), is(equalTo("Vigorelli")));
    assertThat(bike.get().getColour(), is(equalTo("White")));
    assertThat(bike.get().getYear(), is(equalTo(2017)));
    assertThat(bike.get().getPrice(), is(equalTo(1249)));
  }

  @Test
  public void shouldMapToRestResource() {
    final UUID bikeId = UUID.fromString("11edf58d-0d27-470f-a527-3bab79ba5576");
    final UUID ownerId = UUID.fromString("40b8098d-8058-465e-acff-ac1119e57b27");

    final Bike bike =
        Bike.getInstance(bikeId, ownerId, "Cinelli", "Vigorelli", "White", 2017, 1249);

    final Option<BikeResource> bikeResource = BikeInMapper.mapToRestResource(bike);

    assertThat(bikeResource.isDefined(), is(equalTo(true)));
    assertThat(bikeResource.get().getId(), is(equalTo(bikeId)));
    assertThat(bikeResource.get().getOwnerId(), is(equalTo(ownerId)));
    assertThat(bikeResource.get().getMake(), is(equalTo("Cinelli")));
    assertThat(bikeResource.get().getModel(), is(equalTo("Vigorelli")));
    assertThat(bikeResource.get().getColour(), is(equalTo("White")));
    assertThat(bikeResource.get().getYear(), is(equalTo(2017)));
    assertThat(bikeResource.get().getPrice(), is(equalTo(1249)));
  }

  @Test
  public void shouldMapToListOfRestResource() {
    final UUID bikeId = UUID.fromString("11edf58d-0d27-470f-a527-3bab79ba5576");
    final UUID ownerId = UUID.fromString("40b8098d-8058-465e-acff-ac1119e57b27");

    final List<Bike> bikes =
        List.of(Bike.getInstance(bikeId, ownerId, "Cinelli", "Vigorelli", "White", 2017, 1249));

    final List<BikeResource> bikeResources = BikeInMapper.mapToListRestResource(bikes);

    assertThat(bikeResources.size(), is(equalTo(1)));
  }

  @Test
  public void shouldMapWithNullBikeToListOfRestResource() {
    final UUID bikeId = UUID.fromString("11edf58d-0d27-470f-a527-3bab79ba5576");
    final UUID ownerId = UUID.fromString("40b8098d-8058-465e-acff-ac1119e57b27");

    final Bike bike =
        Bike.getInstance(bikeId, ownerId, "Cinelli", "Vigorelli", "White", 2017, 1249);

    final List<Bike> bikes = new ArrayList<>();
    bikes.add(bike);
    bikes.add(null);

    final List<BikeResource> bikeResources = BikeInMapper.mapToListRestResource(bikes);

    assertThat(bikeResources.size(), is(equalTo(1)));
  }

  @Test
  public void shouldMapToEmptyListOfRestResource() {
    List<BikeResource> bikeResources = BikeInMapper.mapToListRestResource(null);

    assertThat(bikeResources.size(), is(equalTo(0)));
  }
}
