package io.redintro.hexbike.adapter.out.persistence.adapter;

import io.redintro.hexbike.adapter.out.persistence.entity.BikeJpaEntity;
import io.redintro.hexbike.adapter.out.persistence.entity.OwnerJpaEntity;
import io.redintro.hexbike.adapter.out.persistence.repository.BikeRepository;
import io.redintro.hexbike.domain.Bike;
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
                .thenReturn(java.util.Optional.of(new BikeJpaEntity(bikeId, "Cinelli", "Vigorelli",
                        "White", 2017, 1249, new OwnerJpaEntity(ownerId, "Jeff",
                        "Jefferson"))));

        Bike bike = bikePersistenceAdapter.findById(bikeId);

        assertThat(bike.getId(), is(equalTo(bikeId)));
        assertThat(bike.getMake(), is(equalTo("Cinelli")));
        assertThat(bike.getModel(), is(equalTo("Vigorelli")));
        assertThat(bike.getColour(), is(equalTo("White")));
        assertThat(bike.getYear(), is(equalTo(2017)));
        assertThat(bike.getPrice(), is(equalTo(1249)));
        assertThat(bike.getOwner().getId(), is(equalTo(ownerId)));
        assertThat(bike.getOwner().getFirstName(), is(equalTo("Jeff")));
        assertThat(bike.getOwner().getLastName(), is(equalTo("Jefferson")));
    }
}