package io.redintro.hexbike.adapter.in.web.mapper;

import io.redintro.hexbike.adapter.in.web.resource.AuthorityResource;
import io.redintro.hexbike.adapter.in.web.resource.UserResource;
import io.redintro.hexbike.domain.Authority;
import io.redintro.hexbike.domain.User;
import org.junit.jupiter.api.Test;

import java.util.Set;
import java.util.UUID;

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
        UUID userId = UUID.randomUUID();
        UUID authorityId = UUID.randomUUID();

        UserResource userResource = new UserResource(userId, "jeff01", "!Password", "admin",
                Set.of(new AuthorityResource(authorityId, "ADMIN")));

        User user = UserInMapper.mapToDomainEntity(userResource);

        assertThat(user.getId(), is(equalTo(userId)));
        assertThat(user.getUsername(), is(equalTo("jeff01")));
        assertThat(user.getPassword(), is(equalTo("!Password")));
        assertThat(user.getRole(), is(equalTo("admin")));
        assertThat(user.getAuthorities().size(), is(equalTo(1)));
    }

    @Test
    public void shouldMapToResource() {
        UUID userId = UUID.randomUUID();
        UUID authorityId = UUID.randomUUID();

        User user = new User(userId, "jeff01", "!Password", "admin",
                Set.of(new Authority(authorityId, "ADMIN")));

        UserResource userResource = UserInMapper.mapToResource(user);

        assertThat(userResource.getId(), is(equalTo(userId)));
        assertThat(userResource.getUsername(), is(equalTo("jeff01")));
        assertThat(userResource.getPassword(), is(equalTo("!Password")));
        assertThat(userResource.getRole(), is(equalTo("admin")));
        assertThat(userResource.getAuthorities().size(), is(equalTo(1)));
    }
}