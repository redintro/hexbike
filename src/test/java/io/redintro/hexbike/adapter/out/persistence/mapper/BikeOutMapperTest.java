package io.redintro.hexbike.adapter.out.persistence.mapper;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import io.redintro.hexbike.adapter.out.persistence.entity.BikeJpaEntity;
import io.redintro.hexbike.adapter.out.persistence.entity.OwnerJpaEntity;
import io.redintro.hexbike.domain.Bike;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class BikeOutMapperTest {
  @Test
  public void shouldCreateBikeOutMapper() {
    BikeOutMapper bikeOutMapper = new BikeOutMapper();
    assertThat(bikeOutMapper, is(notNullValue()));
  }

  @Test
  public void shouldMapToDomainEntity() {
    final UUID bikeId = UUID.fromString("11edf58d-0d27-470f-a527-3bab79ba5576");
    final UUID ownerId = UUID.fromString("40b8098d-8058-465e-acff-ac1119e57b27");

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

  @Test
  public void should() {
    final UUID bikeId = UUID.fromString("11edf58d-0d27-470f-a527-3bab79ba5576");
    final UUID ownerId = UUID.fromString("40b8098d-8058-465e-acff-ac1119e57b27");

    final Bike bike =
        Bike.getInstance(bikeId, ownerId, "Cinelli", "Vigorelli", "White", 2017, 1249);

    final BikeJpaEntity bikeJpaEntity =
        new BikeJpaEntity(
            bikeId,
            "Cinelli",
            "Vigorelli",
            "White",
            2017,
            1249,
            new OwnerJpaEntity(ownerId, "Jeff", "Jefferson"));

    try (MockedStatic<BikeOutMapper> mapper = Mockito.mockStatic(BikeOutMapper.class)) {
      mapper
          .when(() -> BikeOutMapper.mapToDomainEntity(Mockito.any(BikeJpaEntity.class)))
          .thenReturn(bike);
      Bike result = BikeOutMapper.mapToDomainEntity(bikeJpaEntity);

      assertThat(result.getId(), is(equalTo(bikeId)));
    }
  }
}
