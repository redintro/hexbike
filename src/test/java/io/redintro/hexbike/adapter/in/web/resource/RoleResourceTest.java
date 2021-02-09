package io.redintro.hexbike.adapter.in.web.resource;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.UUID;
import org.junit.jupiter.api.Test;

public class RoleResourceTest {
  @Test
  public void shouldCreateRoleResource() {
    final UUID roleId = UUID.fromString("134f7041-27b6-414f-807c-4a607e4542f4");

    final RoleResource roleResource = new RoleResource(roleId, "ADMIN");

    assertThat(roleResource.getId(), is(equalTo(roleId)));
    assertThat(roleResource.getName(), is(equalTo("ADMIN")));
  }
}
