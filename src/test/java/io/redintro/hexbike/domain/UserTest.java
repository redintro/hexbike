package io.redintro.hexbike.domain;

import org.junit.jupiter.api.Test;

import java.util.Set;
import java.util.UUID;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

class UserTest {
    @Test
    public void shouldCreateUser() {
        UUID userId = UUID.randomUUID();
        UUID authorityId = UUID.randomUUID();

        User user = new User(userId, "jeff01", "!Password", "admin",
                Set.of(new Authority(authorityId, "ADMIN")));

        assertThat(user.getId(), is(equalTo(userId)));
        assertThat(user.getUsername(), is(equalTo("jeff01")));
        assertThat(user.getPassword(), is(equalTo("!Password")));
        assertThat(user.getRole(), is(equalTo("admin")));
        assertThat(user.getAuthorities().size(), is(equalTo(1)));
    }
}