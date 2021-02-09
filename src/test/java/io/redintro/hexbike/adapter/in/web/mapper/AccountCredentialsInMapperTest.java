package io.redintro.hexbike.adapter.in.web.mapper;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import io.redintro.hexbike.adapter.in.web.resource.AccountCredentialsResource;
import io.redintro.hexbike.domain.AccountCredentials;
import org.junit.jupiter.api.Test;

class AccountCredentialsInMapperTest {
  @Test
  public void shouldCreateAccountCredentialsInMapper() {
    final AccountCredentialsInMapper bikeInMapper = new AccountCredentialsInMapper();
    assertThat(bikeInMapper, is(notNullValue()));
  }

  @Test
  public void shouldMapToDomainEntity() {
    final AccountCredentialsResource accountCredentialsResource =
        new AccountCredentialsResource("jeff01", "!Password");

    final AccountCredentials accountCredentials =
        AccountCredentialsInMapper.mapToDomainEntity(accountCredentialsResource);

    assertThat(accountCredentials.getUsername(), is(equalTo("jeff01")));
    assertThat(accountCredentials.getPassword(), is(equalTo("!Password")));
  }

  @Test
  public void shouldMapToResource() {
    final AccountCredentials accountCredentials = new AccountCredentials("jeff01", "!Password");

    final AccountCredentialsResource accountCredentialsResource =
        AccountCredentialsInMapper.mapToResource(accountCredentials);

    assertThat(accountCredentialsResource.getUsername(), is(equalTo("jeff01")));
    assertThat(accountCredentialsResource.getPassword(), is(equalTo("!Password")));
  }
}
