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
    final UUID userId = UUID.fromString("9b06bc40-2e96-4259-b880-58bbbd6db38f");
    final UUID roleId = UUID.fromString("134f7041-27b6-414f-807c-4a607e4542f4");

    UserResource userResource =
        new UserResource(userId, "jeff01", "!Password", Set.of(new RoleResource(roleId, "ADMIN")));

    assertThat(userResource.getId(), is(equalTo(userId)));
    assertThat(userResource.getUsername(), is(equalTo("jeff01")));
    assertThat(userResource.getPassword(), is(equalTo("!Password")));
    assertThat(userResource.getRoles().size(), is(equalTo(1)));
  }
}
