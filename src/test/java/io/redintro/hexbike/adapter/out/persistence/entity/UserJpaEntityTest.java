package io.redintro.hexbike.adapter.out.persistence.entity;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import java.util.Set;
import java.util.UUID;
import org.junit.jupiter.api.Test;

class UserJpaEntityTest {
  @Test
  public void shouldCreateUserJpaEntity() {
    final UUID userId = UUID.fromString("9b06bc40-2e96-4259-b880-58bbbd6db38f");
    final UUID roleId = UUID.fromString("134f7041-27b6-414f-807c-4a607e4542f4");

    UserJpaEntity userJpaEntity =
        new UserJpaEntity(
            userId, "jeff01", "!Password", Set.of(new RoleJpaEntity(roleId, "ADMIN")));

    assertThat(userJpaEntity.getId(), is(equalTo(userId)));
    assertThat(userJpaEntity.getUsername(), is(equalTo("jeff01")));
    assertThat(userJpaEntity.getPassword(), is(equalTo("!Password")));
    assertThat(userJpaEntity.getRoles().size(), is(equalTo(1)));
  }
}
