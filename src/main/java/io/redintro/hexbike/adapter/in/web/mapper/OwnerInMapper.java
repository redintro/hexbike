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
                .map(r -> Owner.getInstance(
                        r.getId(),
                        r.getFirstName(),
                        r.getLastName()));
    }

    public static Optional<OwnerResource> mapToResource(Owner owner) {
        return Optional.ofNullable(owner)
                .map(OwnerInMapper::toOwnerResource);
    }

    public static List<OwnerResource> mapToListResource(List<Owner> owners) {
        return owners.stream()
                .filter(Objects::nonNull)
                .map(OwnerInMapper::toOwnerResource)
                .collect(Collectors.toList());
    }

    private static OwnerResource toOwnerResource(Owner owner) {
        return new OwnerResource(
                owner.getId(),
                owner.getFirstName(),
                owner.getLastName());
    }
}
