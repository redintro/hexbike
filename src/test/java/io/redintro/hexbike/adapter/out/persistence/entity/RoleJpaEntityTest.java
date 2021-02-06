package io.redintro.hexbike.adapter.out.persistence.entity;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import java.util.UUID;
import org.junit.jupiter.api.Test;

class RoleJpaEntityTest {
  @Test
  public void shouldCreateRoleJpaEntity() {
    UUID roleId = UUID.randomUUID();

    RoleJpaEntity userJpaEntity = new RoleJpaEntity(roleId, "ADMIN");

    assertThat(userJpaEntity.getId(), is(equalTo(roleId)));
    assertThat(userJpaEntity.getName(), is(equalTo("ADMIN")));
  }
}
