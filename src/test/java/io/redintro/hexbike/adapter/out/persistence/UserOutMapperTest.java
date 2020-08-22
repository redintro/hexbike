package io.redintro.hexbike.adapter.out.persistence;

import io.redintro.hexbike.domain.User;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

class UserOutMapperTest {
    @Test
    public void shouldCreateUserMapper() {
        UserOutMapper userOutMapper = new UserOutMapper();
        assertThat(userOutMapper, is(notNullValue()));
    }

    @Test
    public void shouldMapToDomainEntity() {
        UserJpaEntity userJpaEntity = new UserJpaEntity(1L, "jeff01", "!Password", "admin");

        User user = UserOutMapper.mapToDomainEntity(userJpaEntity);

        assertThat(user.getId(), is(equalTo(1L)));
        assertThat(user.getUsername(), is(equalTo("jeff01")));
        assertThat(user.getPassword(), is(equalTo("!Password")));
        assertThat(user.getRole(), is(equalTo("admin")));
    }

    @Test
    public void should() {
        User user = new User(1L, "jeff01", "!Password", "admin");

        UserJpaEntity userJpaEntity = UserOutMapper.mapToJpaEntity(user);

        assertThat(userJpaEntity.getId(), is(equalTo(1L)));
        assertThat(userJpaEntity.getUsername(), is(equalTo("jeff01")));
        assertThat(userJpaEntity.getPassword(), is(equalTo("!Password")));
        assertThat(userJpaEntity.getRole(), is(equalTo("admin")));
    }
}