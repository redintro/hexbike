package io.redintro.hexbike.domain;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

class AccountCredentialsTest {
    @Test
    public void shouldCreateAccountCredentials() {
        AccountCredentials accountCredentials = new AccountCredentials();
        accountCredentials.setUsername("jeff01");
        accountCredentials.setPassword("!Password");

        assertThat(accountCredentials.getUsername(), is(equalTo("jeff01")));
        assertThat(accountCredentials.getPassword(), is(equalTo("!Password")));
    }
}