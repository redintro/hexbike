package io.redintro.hexbike.adapter.in.web.resource;

public class AddressResource {
  private final String address1;
  private final String address2;

  public AddressResource(String address1, String address2) {
    this.address1 = address1;
    this.address2 = address2;
  }

  public String getAddress1() {
    return address1;
  }

  public String getAddress2() {
    return address2;
  }
}
