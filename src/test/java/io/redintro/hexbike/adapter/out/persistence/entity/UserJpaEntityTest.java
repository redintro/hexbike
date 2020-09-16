package io.redintro.hexbike.adapter.out.persistence.entity;

import org.junit.jupiter.api.Test;

import java.util.Set;
import java.util.UUID;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

class UserJpaEntityTest {
    @Test
    public void shouldCreateUserJpaEntity() {
        UUID userId = UUID.randomUUID();
        UUID roleId = UUID.randomUUID();

        UserJpaEntity userJpaEntity = new UserJpaEntity(userId, "jeff01", "!Password",
                Set.of(new RoleJpaEntity(roleId, "ADMIN")));

        assertThat(userJpaEntity.getId(), is(equalTo(userId)));
        assertThat(userJpaEntity.getUsername(), is(equalTo("jeff01")));
        assertThat(userJpaEntity.getPassword(), is(equalTo("!Password")));
        assertThat(userJpaEntity.getRoles().size(), is(equalTo(1)));
    }
}