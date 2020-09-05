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
import java.util.Optional;
import java.util.UUID;

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

    @Test
    public void shouldFindAll() {
        when(findOwnerPort.findAll()).thenReturn(List.of(new Owner(UUID.randomUUID(), "Jeff", "Jefferson")));

        List<Owner> owners = showOwnerService.findAll();

        assertThat(owners.size(), is(equalTo(1)));
    }

    @Test
    public void shouldFindById() {
        UUID ownerId = UUID.randomUUID();

        Optional<Owner> maybeOwner = Optional.of(new Owner(ownerId, "Jeff", "Jefferson"));
        when(findOwnerPort.findById(any(UUID.class))).thenReturn(maybeOwner);

        Owner owner = showOwnerService.findById(ownerId).get();

        assertThat(owner.getId(), is(equalTo(ownerId)));
    }
}