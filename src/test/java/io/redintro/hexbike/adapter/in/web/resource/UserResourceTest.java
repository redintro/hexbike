package io.redintro.hexbike.adapter.in.web.resource;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

class UserResourceTest {
    @Test
    public void shouldCreateUserResouce() {
        UUID userId = UUID.randomUUID();

        UserResource userResource = new UserResource(userId, "jeff01", "!Password", "admin");

        assertThat(userResource.getId(), is(equalTo(userId)));
        assertThat(userResource.getUsername(), is(equalTo("jeff01")));
        assertThat(userResource.getPassword(), is(equalTo("!Password")));
        assertThat(userResource.getRole(), is(equalTo("admin")));
    }
}