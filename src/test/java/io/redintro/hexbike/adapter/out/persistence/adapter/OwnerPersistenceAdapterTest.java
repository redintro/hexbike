package io.redintro.hexbike.adapter.out.persistence.adapter;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import io.redintro.hexbike.adapter.out.persistence.entity.BikeJpaEntity;
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
    UUID ownerId = UUID.randomUUID();
    UUID bikeId = UUID.randomUUID();

    when(ownerRepository.findAll())
        .thenReturn(
            List.of(
                new OwnerJpaEntity(
                    ownerId,
                    "Jeff",
                    "Jefferson",
                    List.of(
                        new BikeJpaEntity(
                            bikeId,
                            "Cinelli",
                            "Vigorelli",
                            "White",
                            2017,
                            1249,
                            new OwnerJpaEntity(ownerId, "Jeff", "Jefferson"))))));

    List<Owner> owners = ownerPersistenceAdapter.findAll();

    assertThat(owners.size(), is(equalTo(1)));
  }

  @Test
  public void shouldFindByUserName() {
    UUID ownerId = UUID.randomUUID();
    UUID bikeId = UUID.randomUUID();

    when(ownerRepository.findById(any(UUID.class)))
        .thenReturn(
            Option.of(
                    new OwnerJpaEntity(
                        ownerId,
                        "Jeff",
                        "Jefferson",
                        List.of(
                            new BikeJpaEntity(
                                bikeId,
                                "Cinelli",
                                "Vigorelli",
                                "White",
                                2017,
                                1249,
                                new OwnerJpaEntity(ownerId, "Jeff", "Jefferson")))))
                .toJavaOptional());

    Owner owner = ownerPersistenceAdapter.findById(ownerId).get();

    assertThat(owner.getId(), is(equalTo(ownerId)));
    assertThat(owner.getFirstName(), is(equalTo("Jeff")));
    assertThat(owner.getLastName(), is(equalTo("Jefferson")));
  }
}
