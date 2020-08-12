package io.redintro.hexbike.service;

import io.redintro.hexbike.domain.Bike;
import io.redintro.hexbike.domain.Owner;
import io.redintro.hexbike.port.out.FindBikePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

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

    private Bike bike;

    @BeforeEach
    public void setUp() {
        bike = new Bike(1L, "Cinelli", "Vigorelli", "White", 2017,
                1249, new Owner(1L, "Jeff", "Jefferson"));
    }

    @Test
    public void shouldFindAll() {
        when(showBikeService.findAll()).thenReturn(List.of(bike));

        List<Bike> bikes = showBikeService.findAll();

        assertThat(bikes.size(), is(equalTo(1)));
    }

    @Test
    public void shouldFindById() {
        when(showBikeService.findById(any(Long.class))).thenReturn(bike);

        bike = showBikeService.findById(1L);

        assertThat(bike.getId(), is(equalTo(1L)));
    }
}