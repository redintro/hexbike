package io.redintro.hexbike.adapter.in.web.resource;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class RoleResourceTest {
    @Test
    public void shouldCreateRoleResource() {
        UUID roleId = UUID.randomUUID();

        RoleResource roleResource = new RoleResource(roleId, "ADMIN");

        assertThat(roleResource.getId(), is(equalTo(roleId)));
        assertThat(roleResource.getName(), is(equalTo("ADMIN")));
    }
}
