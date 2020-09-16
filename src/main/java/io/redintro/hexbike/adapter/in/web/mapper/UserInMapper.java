package io.redintro.hexbike.adapter.in.web.mapper;

import io.redintro.hexbike.adapter.in.web.resource.RoleResource;
import io.redintro.hexbike.adapter.in.web.resource.UserResource;
import io.redintro.hexbike.domain.Role;
import io.redintro.hexbike.domain.User;

import java.util.stream.Collectors;

public class UserInMapper {
    public static User mapToDomainEntity(UserResource user) {
        return new User(
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                user.getRoles()
                    .stream()
                    .map(r -> new Role(r.getId(), r.getName()))
                    .collect(Collectors.toSet()));
    }

    public static UserResource mapToResource (User user) {
        return new UserResource (
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                user.getRoles()
                    .stream()
                    .map(r -> new RoleResource(r.getId(), r.getName()))
                    .collect(Collectors.toSet()));
    }
}
