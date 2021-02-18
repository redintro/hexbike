package io.redintro.hexbike.adapter.out.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class AddressJpaEntity {
  @Column(name = "address_1")
  private String address1;

  @Column(name = "address_2")
  private String address2;

  public AddressJpaEntity(String address1, String address2) {
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
