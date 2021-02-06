package io.redintro.hexbike.domain;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.junit.jupiter.api.Test;

class AccountCredentialsTest {
  @Test
  public void shouldCreateEmptyAccountCredentials() {
    AccountCredentials accountCredentials = new AccountCredentials();

    assertThat(accountCredentials.getUsername(), is(equalTo(null)));
    assertThat(accountCredentials.getPassword(), is(equalTo(null)));
  }

  @Test
  public void shouldCreateAccountCredentials() {
    AccountCredentials accountCredentials = new AccountCredentials("jeff01", "!Password");

    assertThat(accountCredentials.getUsername(), is(equalTo("jeff01")));
    assertThat(accountCredentials.getPassword(), is(equalTo("!Password")));
  }
}
