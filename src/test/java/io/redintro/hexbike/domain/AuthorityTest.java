package io.redintro.hexbike.domain;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class AuthorityTest {
    @Test
    public void shouldCreateAuthority() {
        final UUID authorityId = UUID.randomUUID();
        final Authority authority = new Authority(authorityId, "ADMIN");

        assertThat(authority.getId(), is(equalTo(authorityId)));
        assertThat(authority.getName(), is(equalTo("ADMIN")));
    }
}
