package io.redintro.hexbike.adapter.out.persistence.entity;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class OwnerJpaEntityTest {
    @Test
    public void shouldCreateOwnerJpaEntity() {
        UUID ownerId = UUID.randomUUID();

        OwnerJpaEntity ownerJpaEntity = new OwnerJpaEntity(ownerId, "Jeff", "Jefferson");

        assertThat(ownerJpaEntity.getId(), is(equalTo(ownerId)));
        assertThat(ownerJpaEntity.getFirstName(), is(equalTo("Jeff")));
        assertThat(ownerJpaEntity.getLastName(), is(equalTo("Jefferson")));
        assertThat(ownerJpaEntity.getBikes(), is(nullValue()));
    }
}