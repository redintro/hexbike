package io.redintro.hexbike.adapter.out.persistence.mapper;

import io.redintro.hexbike.adapter.out.persistence.entity.UserJpaEntity;
import io.redintro.hexbike.domain.User;

public class UserOutMapper {
    public static User mapToDomainEntity(UserJpaEntity user) {
        return new User(
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                user.getRole());
    }

    public static UserJpaEntity mapToJpaEntity(User user) {
        return new UserJpaEntity(
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                user.getRole());
    }
}
