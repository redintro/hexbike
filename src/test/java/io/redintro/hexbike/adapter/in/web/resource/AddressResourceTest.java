package io.redintro.hexbike.adapter.in.web.resource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.Test;

public class AddressResourceTest {
  @Test
  public void shouldCreateAddressResource() {
    final String address1 = "Address 1";
    final String address2 = "Address 2";

    AddressResource addressResource = new AddressResource(address1, address2);

    assertThat(addressResource.getAddress1(), is(equalTo(address1)));
    assertThat(addressResource.getAddress2(), is(equalTo(address2)));
  }
}
