package io.redintro.hexbike.domain;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class RoleTest {
    @Test
    public void shouldCreateRole() {
        final UUID roleId = UUID.randomUUID();
        final Role role = new Role(roleId, "ADMIN");

        assertThat(role.getId(), is(equalTo(roleId)));
        assertThat(role.getName(), is(equalTo("ADMIN")));
    }
}
