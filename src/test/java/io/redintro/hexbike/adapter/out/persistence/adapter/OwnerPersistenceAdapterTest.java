package io.redintro.hexbike.adapter.out.persistence.adapter;

import io.redintro.hexbike.adapter.out.persistence.entity.OwnerJpaEntity;
import io.redintro.hexbike.adapter.out.persistence.repository.OwnerRepository;
import io.redintro.hexbike.domain.Owner;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OwnerPersistenceAdapterTest {
    @Mock
    private OwnerRepository ownerRepository;

    @InjectMocks
    OwnerPersistenceAdapter ownerPersistenceAdapter;

    @Test
    public void shouldFindAll() {
        when(ownerRepository.findAll())
                .thenReturn(List.of(new OwnerJpaEntity(1L, "Jeff", "Jefferson")));

        List<Owner> owners = ownerPersistenceAdapter.findAll();

        assertThat(owners.size(), is(equalTo(1)));
    }

    @Test
    public void shouldFindByUserName() {
        when(ownerRepository.findById(any(Long.class)))
                .thenReturn(Optional.of(new OwnerJpaEntity(1L, "Jeff", "Jefferson")));

        Owner owner = ownerPersistenceAdapter.findById(1L);

        assertThat(owner.getId(), is(equalTo(1L)));
        assertThat(owner.getFirstName(), is(equalTo("Jeff")));
        assertThat(owner.getLastName(), is(equalTo("Jefferson")));
    }
}