package io.redintro.hexbike.adapter.out.persistence;

import io.redintro.hexbike.domain.User;

public class UserMapper {
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
