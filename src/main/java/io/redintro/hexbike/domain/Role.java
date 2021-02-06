package io.redintro.hexbike.domain;

import java.util.UUID;
import org.immutables.value.Value;

@Value.Immutable(builder = false)
public abstract class Role {
  @Value.Parameter
  public abstract UUID getId();

  @Value.Parameter
  public abstract String getName();

  public static Role getInstance(UUID id, String name) {
    return ImmutableRole.of(id, name);
  }
}
