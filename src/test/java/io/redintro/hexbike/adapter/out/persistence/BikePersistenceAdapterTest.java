package io.redintro.hexbike.adapter.out.persistence;

import io.redintro.hexbike.domain.Bike;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

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
        when(bikeRepository.findAll())
                .thenReturn(List.of(new BikeJpaEntity(1L, "Cinelli", "Vigorelli", "White", 2017,
                        1249, new OwnerJpaEntity(1L, "Jeff", "Jefferson"))));

        List<Bike> bikes = bikePersistenceAdapter.findAll();

        assertThat(bikes.size(), is(equalTo(1)));
    }

    @Test
    public void shouldFindById() {
        when(bikeRepository.findById(any(Long.class)))
                .thenReturn(java.util.Optional.of(new BikeJpaEntity(1L, "Cinelli", "Vigorelli",
                        "White", 2017, 1249, new OwnerJpaEntity(1L, "Jeff",
                        "Jefferson"))));

        Bike bike = bikePersistenceAdapter.findById(1L);

        assertThat(bike.getId(), is(equalTo(1L)));
        assertThat(bike.getMake(), is(equalTo("Cinelli")));
        assertThat(bike.getModel(), is(equalTo("Vigorelli")));
        assertThat(bike.getColour(), is(equalTo("White")));
        assertThat(bike.getYear(), is(equalTo(2017)));
        assertThat(bike.getPrice(), is(equalTo(1249)));
        assertThat(bike.getOwner().getId(), is(equalTo(1L)));
        assertThat(bike.getOwner().getFirstName(), is(equalTo("Jeff")));
        assertThat(bike.getOwner().getLastName(), is(equalTo("Jefferson")));
    }
}