package io.redintro.hexbike.domain;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class AccountCredentialsTest {
    @Test
    public void shouldCreateEmptyAccountCredentials() {
        AccountCredentials accountCredentials = new AccountCredentials();

        assertThat(accountCredentials.getUsername(), is(equalTo(null)));
        assertThat(accountCredentials.getPassword(), is(equalTo(null)));
    }

    @Test
    public void shouldCreateAccountCredentials() {
        AccountCredentials accountCredentials = new AccountCredentials("jeff01","!Password");

        assertThat(accountCredentials.getUsername(), is(equalTo("jeff01")));
        assertThat(accountCredentials.getPassword(), is(equalTo("!Password")));
    }
}