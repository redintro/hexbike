package io.redintro.hexbike.adapter.out.persistence.entity;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class OwnerJpaEntityTest {
    @Test
    public void shouldCreateOwnerJpaEntity() {
        OwnerJpaEntity ownerJpaEntity = new OwnerJpaEntity(1L, "Jeff", "Jefferson");

        assertThat(ownerJpaEntity.getId(), is(equalTo(1L)));
        assertThat(ownerJpaEntity.getFirstName(), is(equalTo("Jeff")));
        assertThat(ownerJpaEntity.getLastName(), is(equalTo("Jefferson")));
        assertThat(ownerJpaEntity.getBikes(), is(nullValue()));
    }
}