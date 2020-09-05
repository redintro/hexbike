package io.redintro.hexbike.adapter.in.web.mapper;

import io.redintro.hexbike.adapter.in.web.resource.OwnerResource;
import io.redintro.hexbike.domain.Owner;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class OwnerInMapper {
    public static Optional<Owner> mapToDomainEntity(OwnerResource resource) {
        return resource != null ? Optional.of(
                new Owner(resource.getId(),
                        resource.getFirstName(),
                        resource.getLastName()))
                : Optional.empty();
    }

    public static Optional<OwnerResource> mapToResource(Owner owner) {
        return owner != null ? Optional.of(getOwnerResource(owner)) : Optional.empty();
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
