package io.redintro.hexbike.adapter.out.persistence.mapper;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import io.redintro.hexbike.adapter.out.persistence.entity.BikeJpaEntity;
import io.redintro.hexbike.adapter.out.persistence.entity.OwnerJpaEntity;
import io.redintro.hexbike.domain.Bike;
import java.util.UUID;
import org.junit.jupiter.api.Test;

class BikeOutMapperTest {
  @Test
  public void shouldCreateBikeOutMapper() {
    BikeOutMapper bikeOutMapper = new BikeOutMapper();
    assertThat(bikeOutMapper, is(notNullValue()));
  }

  @Test
  public void shouldMapToDomainEntity() {
    UUID bikeId = UUID.randomUUID();
    UUID ownerId = UUID.randomUUID();

    BikeJpaEntity bikeJpaEntity =
        new BikeJpaEntity(
            bikeId,
            "Cinelli",
            "Vigorelli",
            "White",
            2017,
            1249,
            new OwnerJpaEntity(ownerId, "Jeff", "Jefferson"));

    Bike bike = BikeOutMapper.mapToDomainEntity(bikeJpaEntity);

    assertThat(bike.getId(), is(equalTo(bikeId)));
    assertThat(bike.getOwnerId(), is(equalTo(ownerId)));
    assertThat(bike.getMake(), is(equalTo("Cinelli")));
    assertThat(bike.getModel(), is(equalTo("Vigorelli")));
    assertThat(bike.getColour(), is(equalTo("White")));
    assertThat(bike.getYear(), is(equalTo(2017)));
    assertThat(bike.getPrice(), is(equalTo(1249)));
  }
}
