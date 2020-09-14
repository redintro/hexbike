package io.redintro.hexbike.adapter.out.persistence.mapper;

import io.redintro.hexbike.adapter.out.persistence.entity.AuthorityJpaEntity;
import io.redintro.hexbike.adapter.out.persistence.entity.UserJpaEntity;
import io.redintro.hexbike.domain.Authority;
import io.redintro.hexbike.domain.User;
import org.junit.jupiter.api.Test;

import java.util.Set;
import java.util.UUID;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;

class UserOutMapperTest {
    @Test
    public void shouldCreateUserMapper() {
        UserOutMapper userOutMapper = new UserOutMapper();
        assertThat(userOutMapper, is(notNullValue()));
    }

    @Test
    public void shouldMapToDomainEntity() {
        UUID userId = UUID.randomUUID();
        UUID authorityId = UUID.randomUUID();

        UserJpaEntity userJpaEntity = new UserJpaEntity(userId, "jeff01", "!Password", "admin",
                Set.of(new AuthorityJpaEntity(authorityId, "ADMIN")));

        User user = UserOutMapper.mapToDomainEntity(userJpaEntity);

        assertThat(user.getId(), is(equalTo(userId)));
        assertThat(user.getUsername(), is(equalTo("jeff01")));
        assertThat(user.getPassword(), is(equalTo("!Password")));
        assertThat(user.getRole(), is(equalTo("admin")));
        assertThat(user.getAuthorities().size(), is(equalTo(1)));
    }

    @Test
    public void should() {
        UUID userId = UUID.randomUUID();
        UUID authorityId = UUID.randomUUID();

        User user = new User(userId, "jeff01", "!Password", "admin",
                Set.of(new Authority(authorityId, "ADMIN")));

        UserJpaEntity userJpaEntity = UserOutMapper.mapToJpaEntity(user);

        assertThat(userJpaEntity.getId(), is(equalTo(userId)));
        assertThat(userJpaEntity.getUsername(), is(equalTo("jeff01")));
        assertThat(userJpaEntity.getPassword(), is(equalTo("!Password")));
        assertThat(userJpaEntity.getRole(), is(equalTo("admin")));
        assertThat(userJpaEntity.getAuthorities().size(), is(equalTo(1)));
    }
}