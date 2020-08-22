package io.redintro.hexbike.adapter.in.web.mapper;

import io.redintro.hexbike.adapter.in.web.resource.UserResource;
import io.redintro.hexbike.domain.User;

public class UserInMapper {
    public static User mapToDomainEntity(UserResource user) {
        return new User(
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                user.getRole());
    }

    public static UserResource mapToResource (User user) {
        return new UserResource (
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                user.getRole());
    }
}
