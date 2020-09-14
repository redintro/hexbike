package io.redintro.hexbike.adapter.out.persistence.entity;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

class AuthorityJpaEntityTest {
    @Test
    public void shouldCreateAuthorityJpaEntity() {
        UUID authorityId = UUID.randomUUID();

        AuthorityJpaEntity userJpaEntity = new AuthorityJpaEntity(authorityId, "ADMIN");

        assertThat(userJpaEntity.getId(), is(equalTo(authorityId)));
        assertThat(userJpaEntity.getName(), is(equalTo("ADMIN")));
    }
}