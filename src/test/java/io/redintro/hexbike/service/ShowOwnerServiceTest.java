package io.redintro.hexbike.service;

import io.redintro.hexbike.domain.Owner;
import io.redintro.hexbike.port.out.FindOwnerPort;
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
class ShowOwnerServiceTest {
    @Mock
    private FindOwnerPort findOwnerPort;

    @InjectMocks
    ShowOwnerService showOwnerService;

    private Owner owner;

    @BeforeEach
    public void setUp() {
        owner = new Owner(1L, "Jeff", "Jefferson");
    }

    @Test
    public void shouldFindAll() {
        when(showOwnerService.findAll()).thenReturn(List.of(owner));

        List<Owner> owners = showOwnerService.findAll();

        assertThat(owners.size(), is(equalTo(1)));
    }

    @Test
    public void shouldFindById() {
        when(showOwnerService.findById(any(Long.class))).thenReturn(owner);

        owner = showOwnerService.findById(1L);

        assertThat(owner.getId(), is(equalTo(1L)));
    }
}