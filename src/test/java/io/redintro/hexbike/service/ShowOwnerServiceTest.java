package io.redintro.hexbike.service;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import io.redintro.hexbike.domain.Bike;
import io.redintro.hexbike.domain.Owner;
import io.redintro.hexbike.port.out.FindOwnerPort;
import io.vavr.control.Option;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ShowOwnerServiceTest {
  @Mock private FindOwnerPort findOwnerPort;

  @InjectMocks ShowOwnerService showOwnerService;

  @Test
  public void shouldFindAll() {
    UUID ownerId = UUID.randomUUID();
    UUID bikeId = UUID.randomUUID();

    when(findOwnerPort.findAll())
        .thenReturn(
            List.of(
                Owner.getInstance(
                    ownerId,
                    "Jeff",
                    "Jefferson",
                    List.of(
                        Bike.getInstance(
                            bikeId, ownerId, "Cinelli", "Vigorelli", "White", 2017, 1249)))));

    List<Owner> owners = showOwnerService.findAll();

    assertThat(owners.size(), is(equalTo(1)));
  }

  @Test
  public void shouldFindById() {
    UUID ownerId = UUID.randomUUID();
    UUID bikeId = UUID.randomUUID();
    Option<Owner> maybeOwner =
        Option.of(
            Owner.getInstance(
                ownerId,
                "Jeff",
                "Jefferson",
                List.of(
                    Bike.getInstance(
                        bikeId, ownerId, "Cinelli", "Vigorelli", "White", 2017, 1249))));

    when(findOwnerPort.findById(any(UUID.class))).thenReturn(maybeOwner);

    Owner owner = showOwnerService.findById(ownerId).get();

    assertThat(owner.getId(), is(equalTo(ownerId)));
  }
}
