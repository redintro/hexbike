package io.redintro.hexbike.adapter.out.persistence.entity;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.UUID;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class OwnerJpaEntityTest {
    @Test
    public void shouldCreateOwnerJpaEntity() {
        UUID ownerId = UUID.randomUUID();
        UUID bikeId = UUID.randomUUID();

        OwnerJpaEntity ownerJpaEntity = new OwnerJpaEntity(ownerId, "Jeff", "Jefferson",
                List.of(new BikeJpaEntity(bikeId, "Cinelli", "Vigorelli", "White", 2017,
                        1249, new OwnerJpaEntity())));

        assertThat(ownerJpaEntity.getId(), is(equalTo(ownerId)));
        assertThat(ownerJpaEntity.getFirstName(), is(equalTo("Jeff")));
        assertThat(ownerJpaEntity.getLastName(), is(equalTo("Jefferson")));
        assertThat(ownerJpaEntity.getBikes(), is(notNullValue()));
    }
}