package io.redintro.hexbike.adapter.out.persistence.adapter;

import io.redintro.hexbike.adapter.out.persistence.entity.BikeJpaEntity;
import io.redintro.hexbike.adapter.out.persistence.entity.OwnerJpaEntity;
import io.redintro.hexbike.adapter.out.persistence.repository.BikeRepository;
import io.redintro.hexbike.domain.Bike;
import io.vavr.control.Option;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.UUID;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BikePersistenceAdapterTest {
    @Mock
    private BikeRepository bikeRepository;

    @InjectMocks
    private BikePersistenceAdapter bikePersistenceAdapter;

    @Test
    public void shouldFindAll() {
        UUID bikeId = UUID.randomUUID();
        UUID ownerId = UUID.randomUUID();

        when(bikeRepository.findAll())
                .thenReturn(List.of(new BikeJpaEntity(bikeId, "Cinelli", "Vigorelli", "White", 2017,
                        1249, new OwnerJpaEntity(ownerId, "Jeff", "Jefferson"))));

        List<Bike> bikes = bikePersistenceAdapter.findAll();

        assertThat(bikes.size(), is(equalTo(1)));
    }

    @Test
    public void shouldFindById() {
        UUID bikeId = UUID.randomUUID();
        UUID ownerId = UUID.randomUUID();

        when(bikeRepository.findById(any(UUID.class)))
                .thenReturn(Option.of(new BikeJpaEntity(bikeId, "Cinelli", "Vigorelli",
                        "White", 2017, 1249, new OwnerJpaEntity(ownerId, "Jeff",
                        "Jefferson")))
                        .toJavaOptional());

        Option<Bike> bike = bikePersistenceAdapter.findById(bikeId);

        assertThat(bike.isDefined(), is(equalTo(true)));
        assertThat(bike.get().getId(), is(equalTo(bikeId)));
        assertThat(bike.get().getMake(), is(equalTo("Cinelli")));
        assertThat(bike.get().getModel(), is(equalTo("Vigorelli")));
        assertThat(bike.get().getColour(), is(equalTo("White")));
        assertThat(bike.get().getYear(), is(equalTo(2017)));
        assertThat(bike.get().getPrice(), is(equalTo(1249)));
        assertThat(bike.get().getOwner().getId(), is(equalTo(ownerId)));
        assertThat(bike.get().getOwner().getFirstName(), is(equalTo("Jeff")));
        assertThat(bike.get().getOwner().getLastName(), is(equalTo("Jefferson")));
    }
}