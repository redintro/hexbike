package io.redintro.hexbike.adapter.out.persistence.entity;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;

class UserJpaEntityTest {
    @Test
    public void shouldCreateUserJpaEntity() {
        UUID userId = UUID.randomUUID();

        UserJpaEntity userJpaEntity = new UserJpaEntity(userId, "jeff01", "!Password", "admin", null);

        assertThat(userJpaEntity.getId(), is(equalTo(userId)));
        assertThat(userJpaEntity.getUsername(), is(equalTo("jeff01")));
        assertThat(userJpaEntity.getPassword(), is(equalTo("!Password")));
        assertThat(userJpaEntity.getRole(), is(equalTo("admin")));
        assertThat(userJpaEntity.getAuthorities(), is(nullValue()));
    }
}