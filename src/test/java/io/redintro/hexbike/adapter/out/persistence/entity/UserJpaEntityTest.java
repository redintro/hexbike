package io.redintro.hexbike.adapter.out.persistence.entity;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class UserJpaEntityTest {
    @Test
    public void shouldCreateUserJpaEntity() {
        UserJpaEntity userJpaEntity = new UserJpaEntity(1L, "jeff01", "!Password", "admin");

        assertThat(userJpaEntity.getId(), is(equalTo(1L)));
        assertThat(userJpaEntity.getUsername(), is(equalTo("jeff01")));
        assertThat(userJpaEntity.getPassword(), is(equalTo("!Password")));
        assertThat(userJpaEntity.getRole(), is(equalTo("admin")));
    }
}