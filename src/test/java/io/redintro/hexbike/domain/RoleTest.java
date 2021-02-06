package io.redintro.hexbike.domain;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import java.util.UUID;
import org.junit.jupiter.api.Test;

public class RoleTest {
  @Test
  public void shouldCreateRole() {
    final UUID roleId = UUID.randomUUID();
    final Role role = Role.getInstance(roleId, "ADMIN");

    assertThat(role.getId(), is(equalTo(roleId)));
    assertThat(role.getName(), is(equalTo("ADMIN")));
  }
}
