package io.redintro.hexbike.adapter.in.web.resource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.Test;

public class AccountCredentialsResourceTest {

  @Test
  public void shouldCreateAccountCredentialResource() {
    AccountCredentialsResource accountCredentialsResource = new AccountCredentialsResource();
    accountCredentialsResource.setUsername("jeff01");
    accountCredentialsResource.setPassword("!Password");

    assertThat(accountCredentialsResource.getUsername(), is(equalTo("jeff01")));
    assertThat(accountCredentialsResource.getPassword(), is(equalTo("!Password")));
  }
}
