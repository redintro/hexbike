package io.redintro.hexbike.domain;

import java.util.Set;
import java.util.UUID;
import org.immutables.value.Value;

@Value.Immutable(builder = false)
public abstract class User {
  @Value.Parameter
  public abstract UUID getId();

  @Value.Parameter
  public abstract String getUsername();

  @Value.Parameter
  public abstract String getPassword();

  @Value.Parameter
  public abstract Set<Role> getRoles();

  public static User getInstance(UUID id, String username, String password, Set<Role> roles) {
    return ImmutableUser.of(id, username, password, roles);
  }
}
