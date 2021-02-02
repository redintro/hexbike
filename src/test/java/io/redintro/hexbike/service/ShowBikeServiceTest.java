package io.redintro.hexbike.service;

import io.redintro.hexbike.domain.Bike;
import io.redintro.hexbike.domain.Owner;
import io.redintro.hexbike.port.out.FindBikePort;
import io.vavr.control.Option;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.UUID;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ShowBikeServiceTest {
    @Mock
    private FindBikePort findBikePort;

    @InjectMocks
    private ShowBikeService showBikeService;

    @Test
    public void shouldFindAll() {
        when(findBikePort.findAll())
                .thenReturn(List.of(Bike.getInstance(UUID.randomUUID(), "Cinelli", "Vigorelli",
                        "White", 2017, 1249, Owner.getInstance(UUID.randomUUID(),
                        "Jeff", "Jefferson"))));

        List<Bike> bikes = showBikeService.findAll();

        assertThat(bikes.size(), is(equalTo(1)));
    }

    @Test
    public void shouldFindById() {
        UUID bikeId =  UUID.randomUUID();
        UUID ownerId = UUID.randomUUID();

        when(findBikePort.findById(any(UUID.class))).thenReturn(Option.of(Bike.getInstance(bikeId, "Cinelli", "Vigorelli",
                "White", 2017, 1249, Owner.getInstance(ownerId, "Jeff", "Jefferson"))));

        Option<Bike> bike = showBikeService.findById(bikeId);

        assertThat(bike.isDefined(), is(equalTo(true)));
        assertThat(bike.get().getId(), is(equalTo(bikeId)));
        assertThat(bike.get().getOwner().getId(), is(equalTo(ownerId)));
    }
}