package io.redintro.hexbike.adapter.in.web.mapper;

import io.redintro.hexbike.adapter.in.web.resource.OwnerResource;
import io.redintro.hexbike.domain.Owner;

public class OwnerInMapper {
    public static Owner mapToDomainEntity(OwnerResource owner) {
        return new Owner(
                owner.getId(),
                owner.getFirstName(),
                owner.getLastName());
    }

    public static OwnerResource mapToResource(Owner owner) {
        return new OwnerResource(
                owner.getId(),
                owner.getFirstName(),
                owner.getLastName());
    }
}
