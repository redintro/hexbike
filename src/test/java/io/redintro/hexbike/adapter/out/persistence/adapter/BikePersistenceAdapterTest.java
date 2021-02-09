package io.redintro.hexbike.adapter.out.persistence.adapter;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import io.redintro.hexbike.adapter.out.persistence.entity.BikeJpaEntity;
import io.redintro.hexbike.adapter.out.persistence.entity.OwnerJpaEntity;
import io.redintro.hexbike.adapter.out.persistence.repository.BikeRepository;
import io.redintro.hexbike.domain.Bike;
import io.vavr.control.Option;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class BikePersistenceAdapterTest {
  @Mock private BikeRepository bikeRepository;

  @InjectMocks private BikePersistenceAdapter bikePersistenceAdapter;

  @Test
  public void shouldFindAll() {
    final UUID bikeId = UUID.fromString("11edf58d-0d27-470f-a527-3bab79ba5576");
    final UUID ownerId = UUID.fromString("40b8098d-8058-465e-acff-ac1119e57b27");

    when(bikeRepository.findAll())
        .thenReturn(
            List.of(
                new BikeJpaEntity(
                    bikeId,
                    "Cinelli",
                    "Vigorelli",
                    "White",
                    2017,
                    1249,
                    new OwnerJpaEntity(ownerId, "Jeff", "Jefferson"))));

    List<Bike> bikes = bikePersistenceAdapter.findAll();

    assertThat(bikes.size(), is(equalTo(1)));
  }

  @Test
  public void shouldFindById() {
    final UUID bikeId = UUID.fromString("11edf58d-0d27-470f-a527-3bab79ba5576");
    final UUID ownerId = UUID.fromString("40b8098d-8058-465e-acff-ac1119e57b27");

    when(bikeRepository.findById(any(UUID.class)))
        .thenReturn(
            Option.of(
                    new BikeJpaEntity(
                        bikeId,
                        "Cinelli",
                        "Vigorelli",
                        "White",
                        2017,
                        1249,
                        new OwnerJpaEntity(ownerId, "Jeff", "Jefferson")))
                .toJavaOptional());

    Option<Bike> bike = bikePersistenceAdapter.findById(bikeId);

    assertThat(bike.isDefined(), is(equalTo(true)));
    assertThat(bike.get().getId(), is(equalTo(bikeId)));
    assertThat(bike.get().getOwnerId(), is(equalTo(ownerId)));
    assertThat(bike.get().getMake(), is(equalTo("Cinelli")));
    assertThat(bike.get().getModel(), is(equalTo("Vigorelli")));
    assertThat(bike.get().getColour(), is(equalTo("White")));
    assertThat(bike.get().getYear(), is(equalTo(2017)));
    assertThat(bike.get().getPrice(), is(equalTo(1249)));
  }
}
