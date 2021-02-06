package io.redintro.hexbike.service;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import io.redintro.hexbike.domain.Bike;
import io.redintro.hexbike.port.out.FindBikePort;
import io.vavr.control.Option;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ShowBikeServiceTest {
  @Mock private FindBikePort findBikePort;

  @InjectMocks private ShowBikeService showBikeService;

  @Test
  public void shouldFindAll() {
    when(findBikePort.findAll())
        .thenReturn(
            List.of(
                Bike.getInstance(
                    UUID.randomUUID(),
                    UUID.randomUUID(),
                    "Cinelli",
                    "Vigorelli",
                    "White",
                    2017,
                    1249)));

    List<Bike> bikes = showBikeService.findAll();

    assertThat(bikes.size(), is(equalTo(1)));
  }

  @Test
  public void shouldFindById() {
    UUID bikeId = UUID.randomUUID();
    UUID ownerId = UUID.randomUUID();

    when(findBikePort.findById(any(UUID.class)))
        .thenReturn(
            Option.of(
                Bike.getInstance(bikeId, ownerId, "Cinelli", "Vigorelli", "White", 2017, 1249)));

    Option<Bike> bike = showBikeService.findById(bikeId);

    assertThat(bike.isDefined(), is(equalTo(true)));
    assertThat(bike.get().getId(), is(equalTo(bikeId)));
    assertThat(bike.get().getOwnerId(), is(equalTo(ownerId)));
  }
}
