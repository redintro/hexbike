package io.redintro.hexbike.adapter.in.web.mapper;

import io.redintro.hexbike.adapter.in.web.resource.AuthorityResource;
import io.redintro.hexbike.adapter.in.web.resource.UserResource;
import io.redintro.hexbike.domain.Authority;
import io.redintro.hexbike.domain.User;

import java.util.stream.Collectors;

public class UserInMapper {
    public static User mapToDomainEntity(UserResource user) {
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

    public static UserResource mapToResource (User user) {
        return new UserResource (
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                user.getRole(),
                user.getAuthorities()
                    .stream()
                    .map(a -> new AuthorityResource(a.getId(), a.getName()))
                    .collect(Collectors.toSet()));
    }
}
