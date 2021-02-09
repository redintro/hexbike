package io.redintro.hexbike.adapter.out.persistence.adapter;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import io.redintro.hexbike.adapter.out.persistence.entity.OwnerJpaEntity;
import io.redintro.hexbike.adapter.out.persistence.repository.OwnerRepository;
import io.redintro.hexbike.domain.Owner;
import io.vavr.control.Option;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class OwnerPersistenceAdapterTest {
  @Mock private OwnerRepository ownerRepository;

  @InjectMocks OwnerPersistenceAdapter ownerPersistenceAdapter;

  @Test
  public void shouldFindAll() {
    final UUID ownerId = UUID.fromString("40b8098d-8058-465e-acff-ac1119e57b27");

    when(ownerRepository.findAll())
        .thenReturn(List.of(new OwnerJpaEntity(ownerId, "Jeff", "Jefferson")));

    List<Owner> owners = ownerPersistenceAdapter.findAll();

    assertThat(owners.size(), is(equalTo(1)));
  }

  @Test
  public void shouldFindByUserName() {
    final UUID ownerId = UUID.fromString("40b8098d-8058-465e-acff-ac1119e57b27");

    when(ownerRepository.findById(any(UUID.class)))
        .thenReturn(Option.of(new OwnerJpaEntity(ownerId, "Jeff", "Jefferson")).toJavaOptional());

    Owner owner = ownerPersistenceAdapter.findById(ownerId).get();

    assertThat(owner.getId(), is(equalTo(ownerId)));
    assertThat(owner.getFirstName(), is(equalTo("Jeff")));
    assertThat(owner.getLastName(), is(equalTo("Jefferson")));
  }
}
