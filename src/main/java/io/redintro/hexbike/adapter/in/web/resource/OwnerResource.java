package io.redintro.hexbike.adapter.in.web.resource;

import java.util.UUID;

public class OwnerResource {
  private final UUID id;
  private final String firstName;
  private final String lastName;

  public OwnerResource(UUID id, String firstName, String lastName) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public UUID getId() {
    return id;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }
}
