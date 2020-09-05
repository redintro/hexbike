package io.redintro.hexbike.adapter.in.web.mapper;

import io.redintro.hexbike.adapter.in.web.resource.OwnerResource;
import io.redintro.hexbike.domain.Owner;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class OwnerInMapper {
    public static Optional<Owner> mapToDomainEntity(OwnerResource resource) {
        return Optional.ofNullable(resource)
                .map(r -> new Owner(
                        resource.getId(),
                        resource.getFirstName(),
                        resource.getLastName()));
    }

    public static Optional<OwnerResource> mapToResource(Owner owner) {
        return Optional.ofNullable(owner).map(OwnerInMapper::getOwnerResource);
    }

    public static List<OwnerResource> mapToListResource(List<Owner> owners) {
        return owners.stream()
                .filter(Objects::nonNull)
                .map(OwnerInMapper::getOwnerResource)
                .collect(Collectors.toList());
    }

    private static OwnerResource getOwnerResource(Owner owner) {
        return new OwnerResource(
                owner.getId(),
                owner.getFirstName(),
                owner.getLastName());
    }
}
