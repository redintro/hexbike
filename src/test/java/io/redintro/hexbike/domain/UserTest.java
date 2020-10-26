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
        UUID roleId = UUID.randomUUID();

        User user = User.getInstance(userId, "jeff01", "!Password",
                Set.of(Role.getInstance(roleId, "ADMIN")));

        assertThat(user.getId(), is(equalTo(userId)));
        assertThat(user.getUsername(), is(equalTo("jeff01")));
        assertThat(user.getPassword(), is(equalTo("!Password")));
        assertThat(user.getRoles().size(), is(equalTo(1)));
    }
}