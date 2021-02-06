package io.redintro.hexbike.adapter.in.web.resource;

import java.util.UUID;

public class RoleResource {
  private final UUID id;
  private final String name;

  public RoleResource(UUID id, String name) {
    this.id = id;
    this.name = name;
  }

  public UUID getId() {
    return id;
  }

  public String getName() {
    return name;
  }
}
