package io.redintro.hexbike.service;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

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
    final UUID ownerId = UUID.fromString("40b8098d-8058-465e-acff-ac1119e57b27");

    when(findOwnerPort.findAll())
        .thenReturn(List.of(Owner.getInstance(ownerId, "Jeff", "Jefferson")));

    List<Owner> owners = showOwnerService.findAll();

    assertThat(owners.size(), is(equalTo(1)));
  }

  @Test
  public void shouldFindById() {
    final UUID ownerId = UUID.fromString("40b8098d-8058-465e-acff-ac1119e57b27");

    Option<Owner> maybeOwner = Option.of(Owner.getInstance(ownerId, "Jeff", "Jefferson"));

    when(findOwnerPort.findById(any(UUID.class))).thenReturn(maybeOwner);

    Owner owner = showOwnerService.findById(ownerId).get();

    assertThat(owner.getId(), is(equalTo(ownerId)));
  }
}
