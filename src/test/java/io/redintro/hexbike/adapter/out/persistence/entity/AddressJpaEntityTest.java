package io.redintro.hexbike.adapter.out.persistence.entity;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

import org.junit.jupiter.api.Test;

class AddressJpaEntityTest {
  @Test
  public void shouldCreateAddressJpaEntity() {
    final String address1 = "Address 1";
    final String address2 = "Address 2";

    final AddressJpaEntity addressJpaEntity = new AddressJpaEntity(address1, address2);

    assertThat(addressJpaEntity, is(notNullValue()));
    assertThat(addressJpaEntity.getAddress1(), is(equalTo(address1)));
    assertThat(addressJpaEntity.getAddress2(), is(equalTo(address2)));
  }
}
