package io.redintro.hexbike.adapter.out.persistence.mapper;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

import io.redintro.hexbike.adapter.out.persistence.entity.RoleJpaEntity;
import io.redintro.hexbike.adapter.out.persistence.entity.UserJpaEntity;
import io.redintro.hexbike.domain.Role;
import io.redintro.hexbike.domain.User;
import java.util.Set;
import java.util.UUID;
import org.junit.jupiter.api.Test;

class UserOutMapperTest {
  @Test
  public void shouldCreateUserMapper() {
    UserOutMapper userOutMapper = new UserOutMapper();
    assertThat(userOutMapper, is(notNullValue()));
  }

  @Test
  public void shouldMapToDomainEntity() {
    final UUID userId = UUID.fromString("9b06bc40-2e96-4259-b880-58bbbd6db38f");
    final UUID roleId = UUID.fromString("134f7041-27b6-414f-807c-4a607e4542f4");

    UserJpaEntity userJpaEntity =
        new UserJpaEntity(
            userId, "jeff01", "!Password", Set.of(new RoleJpaEntity(roleId, "ADMIN")));

    User user = UserOutMapper.mapToDomainEntity(userJpaEntity);

    assertThat(user.getId(), is(equalTo(userId)));
    assertThat(user.getUsername(), is(equalTo("jeff01")));
    assertThat(user.getPassword(), is(equalTo("!Password")));
    assertThat(user.getRoles().size(), is(equalTo(1)));
  }

  @Test
  public void should() {
    final UUID userId = UUID.fromString("9b06bc40-2e96-4259-b880-58bbbd6db38f");
    final UUID roleId = UUID.fromString("134f7041-27b6-414f-807c-4a607e4542f4");

    final User user =
        User.getInstance(userId, "jeff01", "!Password", Set.of(Role.getInstance(roleId, "ADMIN")));

    UserJpaEntity userJpaEntity = UserOutMapper.mapToJpaEntity(user);

    assertThat(userJpaEntity.getId(), is(equalTo(userId)));
    assertThat(userJpaEntity.getUsername(), is(equalTo("jeff01")));
    assertThat(userJpaEntity.getPassword(), is(equalTo("!Password")));
    assertThat(userJpaEntity.getRoles().size(), is(equalTo(1)));
  }
}
