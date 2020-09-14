package io.redintro.hexbike.adapter.out.persistence.mapper;

import io.redintro.hexbike.adapter.out.persistence.entity.AuthorityJpaEntity;
import io.redintro.hexbike.adapter.out.persistence.entity.UserJpaEntity;
import io.redintro.hexbike.domain.Authority;
import io.redintro.hexbike.domain.User;

import java.util.stream.Collectors;

public class UserOutMapper {
    public static User mapToDomainEntity(UserJpaEntity user) {
        return new User(
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                user.getRole(),
                user.getAuthorities()
                        .stream()
                        .map(a -> new Authority(a.getId(), a.getName()))
                        .collect(Collectors.toSet()));
    }

    public static UserJpaEntity mapToJpaEntity(User user) {
        return new UserJpaEntity(
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                user.getRole(),
                user.getAuthorities()
                        .stream()
                        .map(a -> new AuthorityJpaEntity(a.getId(), a.getName()))
                        .collect(Collectors.toSet()));
    }
}
