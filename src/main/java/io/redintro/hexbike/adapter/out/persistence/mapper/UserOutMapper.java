package io.redintro.hexbike.adapter.out.persistence.mapper;

import io.redintro.hexbike.adapter.out.persistence.entity.RoleJpaEntity;
import io.redintro.hexbike.adapter.out.persistence.entity.UserJpaEntity;
import io.redintro.hexbike.domain.Role;
import io.redintro.hexbike.domain.User;

import java.util.stream.Collectors;

public class UserOutMapper {
    public static User mapToDomainEntity(UserJpaEntity user) {
        return User.getInstance(
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                user.getRoles()
                        .stream()
                        .map(a -> Role.getInstance(a.getId(), a.getName()))
                        .collect(Collectors.toSet()));
    }

    public static UserJpaEntity mapToJpaEntity(User user) {
        return new UserJpaEntity(
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                user.getRoles()
                        .stream()
                        .map(a -> new RoleJpaEntity(a.getId(), a.getName()))
                        .collect(Collectors.toSet()));
    }
}
