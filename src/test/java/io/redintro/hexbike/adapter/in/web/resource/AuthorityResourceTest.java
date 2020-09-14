package io.redintro.hexbike.adapter.in.web.resource;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class AuthorityResourceTest {
    @Test
    public void shouldCreateAuthorityResource() {
        UUID authorityId = UUID.randomUUID();

        AuthorityResource authorityResource = new AuthorityResource(authorityId, "ADMIN");

        assertThat(authorityResource.getId(), is(equalTo(authorityId)));
        assertThat(authorityResource.getName(), is(equalTo("ADMIN")));
    }
}
