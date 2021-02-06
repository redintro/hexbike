package io.redintro.hexbike.adapter.in.web.resource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import java.util.Set;
import java.util.UUID;
import org.junit.jupiter.api.Test;

class UserResourceTest {
  @Test
  public void shouldCreateUserResource() {
    UUID userId = UUID.randomUUID();
    UUID roleId = UUID.randomUUID();

    UserResource userResource =
        new UserResource(userId, "jeff01", "!Password", Set.of(new RoleResource(roleId, "ADMIN")));

    assertThat(userResource.getId(), is(equalTo(userId)));
    assertThat(userResource.getUsername(), is(equalTo("jeff01")));
    assertThat(userResource.getPassword(), is(equalTo("!Password")));
    assertThat(userResource.getRoles().size(), is(equalTo(1)));
  }
}
