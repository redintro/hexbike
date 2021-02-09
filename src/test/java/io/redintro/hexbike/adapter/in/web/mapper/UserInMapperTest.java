package io.redintro.hexbike.adapter.in.web.mapper;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import io.redintro.hexbike.adapter.in.web.resource.RoleResource;
import io.redintro.hexbike.adapter.in.web.resource.UserResource;
import io.redintro.hexbike.domain.Role;
import io.redintro.hexbike.domain.User;
import java.util.Set;
import java.util.UUID;
import org.junit.jupiter.api.Test;

class UserInMapperTest {
  @Test
  public void shouldCreateUserInMapper() {
    UserInMapper userMapper = new UserInMapper();
    assertThat(userMapper, is(notNullValue()));
  }

  @Test
  public void shouldMapToDomainEntity() {
    final UUID userId = UUID.fromString("9b06bc40-2e96-4259-b880-58bbbd6db38f");
    final UUID roleId = UUID.fromString("134f7041-27b6-414f-807c-4a607e4542f4");

    final UserResource userResource =
        new UserResource(userId, "jeff01", "!Password", Set.of(new RoleResource(roleId, "ADMIN")));

    final User user = UserInMapper.mapToDomainEntity(userResource);

    assertThat(user.getId(), is(equalTo(userId)));
    assertThat(user.getUsername(), is(equalTo("jeff01")));
    assertThat(user.getPassword(), is(equalTo("!Password")));
    assertThat(user.getRoles().size(), is(equalTo(1)));
  }

  @Test
  public void shouldMapToResource() {
    final UUID userId = UUID.fromString("9b06bc40-2e96-4259-b880-58bbbd6db38f");
    final UUID roleId = UUID.fromString("134f7041-27b6-414f-807c-4a607e4542f4");

    final User user =
        User.getInstance(userId, "jeff01", "!Password", Set.of(Role.getInstance(roleId, "ADMIN")));

    final UserResource userResource = UserInMapper.mapToResource(user);

    assertThat(userResource.getId(), is(equalTo(userId)));
    assertThat(userResource.getUsername(), is(equalTo("jeff01")));
    assertThat(userResource.getPassword(), is(equalTo("!Password")));
    assertThat(userResource.getRoles().size(), is(equalTo(1)));
  }
}
