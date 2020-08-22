package io.redintro.hexbike.adapter.in.web.resource;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

class UserResourceTest {
    @Test
    public void shouldCreateUserResouce() {
        UserResource userResource = new UserResource(1L, "jeff01", "!Password", "admin");

        assertThat(userResource.getId(), is(equalTo(1L)));
        assertThat(userResource.getUsername(), is(equalTo("jeff01")));
        assertThat(userResource.getPassword(), is(equalTo("!Password")));
        assertThat(userResource.getRole(), is(equalTo("admin")));
    }
}