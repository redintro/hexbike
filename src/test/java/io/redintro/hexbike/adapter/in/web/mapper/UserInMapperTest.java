package io.redintro.hexbike.adapter.in.web.mapper;

import io.redintro.hexbike.adapter.in.web.resource.UserResource;
import io.redintro.hexbike.domain.User;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class UserInMapperTest {
    @Test
    public void shouldCreateUserInMapper() {
        UserInMapper userMapper = new UserInMapper();
        assertThat(userMapper, is(notNullValue()));
    }

    @Test
    public void shouldMapToDomainEntity() {
        UserResource userResource = new UserResource(1L, "jeff01", "!Password", "admin");

        User user = UserInMapper.mapToDomainEntity(userResource);

        assertThat(user.getId(), is(equalTo(1L)));
        assertThat(user.getUsername(), is(equalTo("jeff01")));
        assertThat(user.getPassword(), is(equalTo("!Password")));
        assertThat(user.getRole(), is(equalTo("admin")));
    }

    @Test
    public void shouldMapToResource() {
        User user = new User(1L, "jeff01", "!Password", "admin");

        UserResource userResource = UserInMapper.mapToResource(user);

        assertThat(userResource.getId(), is(equalTo(1L)));
        assertThat(userResource.getUsername(), is(equalTo("jeff01")));
        assertThat(userResource.getPassword(), is(equalTo("!Password")));
        assertThat(userResource.getRole(), is(equalTo("admin")));
    }
}