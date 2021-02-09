package io.redintro.hexbike.domain;

import java.util.UUID;
import org.immutables.value.Value;

@Value.Immutable(builder = false)
public abstract class Owner {
  @Value.Parameter
  public abstract UUID getId();

  @Value.Parameter
  public abstract String getFirstName();

  @Value.Parameter
  public abstract String getLastName();

  public static Owner getInstance(UUID id, String firstName, String lastName) {
    return ImmutableOwner.of(id, firstName, lastName);
  }
}
