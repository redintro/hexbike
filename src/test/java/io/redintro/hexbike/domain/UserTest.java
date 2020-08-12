package io.redintro.hexbike.domain;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

class UserTest {
    @Test
    public void shouldCreateUser() {
        User user = new User(1L, "jeff01", "!Password", "admin");

        assertThat(user.getId(), is(equalTo(1L)));
        assertThat(user.getUsername(), is(equalTo("jeff01")));
        assertThat(user.getPassword(), is(equalTo("!Password")));
        assertThat(user.getRole(), is(equalTo("admin")));
    }
}