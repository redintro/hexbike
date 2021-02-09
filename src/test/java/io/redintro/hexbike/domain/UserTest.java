package io.redintro.hexbike.domain;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import java.util.Set;
import java.util.UUID;
import org.junit.jupiter.api.Test;

class UserTest {
  @Test
  public void shouldCreateUser() {
    final UUID userId = UUID.fromString("9b06bc40-2e96-4259-b880-58bbbd6db38f");
    final UUID roleId = UUID.fromString("134f7041-27b6-414f-807c-4a607e4542f4");
    final User user =
        User.getInstance(userId, "jeff01", "!Password", Set.of(Role.getInstance(roleId, "ADMIN")));

    assertThat(user.getId(), is(equalTo(userId)));
    assertThat(user.getUsername(), is(equalTo("jeff01")));
    assertThat(user.getPassword(), is(equalTo("!Password")));
    assertThat(user.getRoles().size(), is(equalTo(1)));
  }
}
