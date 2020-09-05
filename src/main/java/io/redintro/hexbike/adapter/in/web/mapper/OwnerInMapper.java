package io.redintro.hexbike.adapter.in.web.mapper;

import io.redintro.hexbike.adapter.in.web.resource.OwnerResource;
import io.redintro.hexbike.domain.Owner;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class OwnerInMapper {
    public static Owner mapToDomainEntity(OwnerResource owner) {
        return new Owner(
                owner.getId(),
                owner.getFirstName(),
                owner.getLastName());
    }

    public static Optional<OwnerResource> mapToResource(Optional<Owner> owner) {
        return owner.map(o -> getOwnerResource(o));
    }

    private static OwnerResource getOwnerResource(Owner o) {
        return new OwnerResource(
                o.getId(),
                o.getFirstName(),
                o.getLastName());
    }

    public static List<OwnerResource> mapToListResource(List<Owner> owners) {
        return owners.stream()
                .filter(Objects::nonNull)
                .map(OwnerInMapper::getOwnerResource)
                .collect(Collectors.toList());
    }
}
